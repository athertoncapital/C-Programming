import java.io.File;
import java.util.*;
import java.io.IOException;
import java.util.HashMap;//Hash table based implementation of the Map interface. java.lang.Object/java.util.AbstractMap<K,V>/java.util.HashMap<K,V>
import java.util.ArrayList;
import java.util.Collections;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Huffman {
    public static void main(String[] args) {
    try {
        //The input parameter to the main function is an array of strings.
        /*for (String s: args) {
            System.out.println(s);
        }*/
        /* use constructor as if functional programming style*/
        CommandLineInputs cmdli = new CommandLineInputs(args);
        if(!cmdli.hasOthers()){
            int Case = 0;//Compress
            if(cmdli.isFunct("-u")) Case = 1;//unzip
            switch (Case) {
                case 0: //Compress
                    HuffmanTree hufftree = new HuffmanTree(args[args.length - 2], args[args.length - 1]);
                    if(cmdli.isFunct("-f")) hufftree.zipInputFile("force");
                    else hufftree.zipInputFile("");
                    if(cmdli.isFunct("-v")) hufftree.VerboseOutput();
                    break;
                case 1: //unzip
                    if(cmdli.isFunct("-u")){
                        print_hufftree prihufftee = new print_hufftree();
                        prihufftee.UnzipFile(args[args.length - 2], args[args.length - 1]);
                        if(cmdli.isFunct("-v")) prihufftee.VerboseOutput();
                    break;
                    }
            }
        }
        else
        {
        instruction:
            System.out.println("Your input command line should expect to be called as follows:");
            System.out.println("java Huffman (-c|-u) [-v] [-f]  infile outfile");
            System.out.println("where:");
            System.out.println("  (-c|-u) stands for either -c (for compress), or -u (for uncompress)");
            System.out.println("  [-v] stands for an optional -v flag (for VerboseOutput)");
            System.out.println("  [-f] stands for an optional -f flag, that forces compression even if the compressed file will be larger than the original file");
            System.out.println("  infile is the input file");
            System.out.println("  outfile is the output file");
            System.out.println("The flags -f and -v can be in either order.  So, the following would all be legal:");
            System.out.println("  java Huffman -c test test.huff");
            System.out.println("  java Huffman -c -v myTestFile myCompressedFile");
            System.out.println("  java Huffman -c -f -v test test.huff");
            System.out.println("  java Huffman -u -f test1.huff test2");
            System.out.println("  java Huffman -u -f -v test1.huff test2");
        }
    } catch (Exception e) {
            System.err.println("Caught Exception: " + e.getMessage());
            System.exit(1);
        }
    }
    static class CommandLineInputs {
        private String[] args; //The input parameter to the main function is an array of strings.
        private HashMap<String, String> m;
        /*Refathttps://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html*/
        //CommandLineInputs Constructor
        public CommandLineInputs(String[] args) {
            //for (String s: args) {
              //  System.out.println(s);
            //}
            
            m = new HashMap<String, String>();
            this.args = args;
            if (args.length == 0) {
                System.out.println("No arguments entered");
                System.exit(0);
                
            }
            // adds the arguments to the hash map when the argument parser gets
            // initialized.
            for (int i = 0; i < args.length; i++) {
                addToMap(args[i]);
            }
        }
        public boolean hasOthers() {
            int[] cmdCheck = { 0, 0, 0};
            String flag01="-c";
            String flag02="-u";
            String flag1="-v";
            String flag2="-f";
            for (int i = 0; i < args.length; i++) {
                if (flag01.equals(args[i])) {
                    cmdCheck[0]++;
                }
                if (flag02.equals(args[i])) {
                    cmdCheck[0]++;
                }
                if (flag1.equals(args[i])) {
                    cmdCheck[1]++;
                }
                if (flag2.equals(args[i])) {
                    cmdCheck[2]++;
                }
            }
            
            if(cmdCheck[0]==1&&cmdCheck[1]<=1&&cmdCheck[2]<=1&&args.length<=5)
                return false;
            else
                return true;
            
        }
        
        // adds the flag given and the associated value into a hash map.
        // if the flag has no value associated with it, a blank is set as its value.
        public void addToMap(String flag) {
            if (flag.startsWith("-")&&isFunct(flag)&&hasValue(flag)) this.m.put(flag, getValue(flag));
                    else this.m.put(flag, "");
        }
        
        // check if the flag given as a parameter can be found as an argument.
        public boolean isFunct(String flag) {
            for (int i = 0; i < args.length; i++) {
                if (flag.equals(args[i])) {
                    return true;
                }
            }
            return false;
        }

        
        // checks if there is a value associated with the given flag.
        public boolean hasValue(String flag) {
            for (int i = 0; i < args.length; i++)
                if (flag.equals(args[i])&& i < args.length - 1 && !args[i + 1].startsWith("-")) return true;
            return false;
        }
        
        // gets the value for the given flag
        public String getValue(String flag) {
            String value = "";
            if (hasValue(flag)) {
                for (int i = 0; i < args.length; i++) {
                    if (flag.equals(args[i])) {
                        value = args[i + 1];
                    }
                }
                
            }
            return value;
        }
        
        // counts the number of flags given.
        public int numFlags() {
            int flagCount = 0;
            for (String s : this.args) {
                if (s.startsWith("-")) {
                    flagCount++;
                }
            }
            
            return flagCount;
        }
        
        // counts the number of arguments given.
        public int numArguments() {
            int argCount = 0;
            for (String s : this.args) {
                if (s.startsWith("-")&&hasValue(s)) ++argCount;
            }
            return argCount;
        }
    }

    
    static class print_hufftree {
        
        private BinaryFile result, input;
        private TextFile tf;
        private TreeElem node;
        
        //Encoding File: in binary
        public void compressFile(String inputFile, String resultFile, String[] codeArray, TreeElem node){
            File file = new File(resultFile);
            file.delete();
            result = new BinaryFile(resultFile, 'w');
            
            tf  = new TextFile(inputFile, 'r');
            result.writeChar('H');
            result.writeChar('F');
            serializeTree(node);
            Character c;
            
            while(!tf.EndOfFile()){
                c = tf.readChar();
                String s = codeArray[c.hashCode()];
                for(int i = 0; i < s.length(); i++){
                    if(s.charAt(i) == '1')result.writeBit(true);
                    else result.writeBit(false);
                }
            }
            //Don't forget to close the result file when you are done...
            result.close();
            
        }
        
        //Writes the huffman tree out in binary to the specified file
        public void serializeTree(TreeElem tree){
            if (tree == null) return;
            if ((tree.getLeftChild() == null) && (tree.getRightChild() == null)){
                result.writeBit(true);
                result.writeChar(tree.getValue());
                return;}
            result.writeBit(false);
            serializeTree(tree.getLeftChild());
            serializeTree(tree.getRightChild());
        }
        
        //Reads in the inputfile(Huffman encoded file) and writes out the decoded file to resultFile
        public void UnzipFile(String inputFile, String resultFile){
            File file = new File(resultFile);
            file.delete();
            tf = new TextFile(resultFile, 'w');
            input = new BinaryFile(inputFile, 'r');
            int i = 0;
            String s = "";
            
            while(i < 2){
                Character c = input.readChar();
                s = s.concat(c.toString());
                i++;
            }
            
            if(s.equals("HF")){
                System.out.println("Unziping...");
                if(input.readBit() == false){
                    node  = new TreeElem('.', 0);
                    node.setLeftChild(rebuildTree());
                    node.setRightChild(rebuildTree());
                    
                }else{
                    
                    node = new TreeElem(input.readChar(), 0);
                }
                
                while(!input.EndOfFile()){
                    if(node.getLeftChild() == null && node.getRightChild() == null){
                        tf.writeChar(node.getValue());
                        input.readBit();
                        
                    }else{
                        traverseTree(node);
                        
                    }
                    
                }
                tf.close();
                System.out.println("Success!");
                
            }else{
                System.out.println("Failed to Unzip file");
            }
            
            
        }
        
        public void traverseTree(TreeElem node){
            if(node.getLeftChild() == null && node.getRightChild() == null){
                tf.writeChar(node.getValue());
                return;
            }
            if(input.readBit() == false){
                traverseTree(node.getLeftChild());
            }else{
                traverseTree(node.getRightChild());
            }
        }
        
        public TreeElem rebuildTree(){
            if(input.readBit() == true){
                TreeElem n = new TreeElem(input.readChar(), 0);
                return n;
            }
            TreeElem node = new TreeElem('.', 0);
            node.setLeftChild(rebuildTree());
            node.setRightChild(rebuildTree());
            return node;
        }
        
        public void VerboseOutput(){
            System.out.println("=====================");
            System.out.println("Huffman Tree");
            System.out.println("=====================");
            print(node, 1);
        }
        
        private void print(TreeElem tree, int indent) {
            if (tree != null) {
                for(int i=0; i<indent; i++) {
                    System.out.print("\t");
                    
                }
                
                System.out.println(tree.getValue() + " : " + tree.getF());
                print(tree.getLeftChild(), indent + 1);
                print(tree.getRightChild(), indent + 1);
            }
            
        }
        
    }

    static class HuffmanTree {
        private TextFile tf;
        private HashMap<Character, Integer> charFreq;
        private String textFile, resultFile;
        private ArrayList<TreeElem> nodeSet;
        private TreeElem node;
        private String[] bitStringArray;
        private print_hufftree hw;
        private int originalFileSize, compressedFileSize;
        
        public HuffmanTree(String textFile, String resultFile){
            charFreq = new HashMap<Character, Integer>();
            nodeSet = new ArrayList<TreeElem>();
            this.textFile = textFile;
            hw = new print_hufftree();
            this.resultFile = resultFile;
            
        }
        
        public void zipInputFile(String flag){
            tf = new TextFile(textFile, 'r');
            originalFileSize = 0;
            System.out.println("Your input file is loading...");
            while(!tf.EndOfFile()){
                char c = tf.readChar();
                originalFileSize++;
                if(charFreq.containsKey(c)){
                    
                    charFreq.put(c, charFreq.get(c) + 1);
                }else{
                    charFreq.put(c, 1);
                }
                
            }
            
            originalFileSize = originalFileSize * 8;
            
            createNodes();
            computeCompressedFileSize();
            
            tf.rewind();
            
            if(flag.equals("force")){
                System.out.println("Compressing...");
                hw.compressFile(textFile, resultFile, bitStringArray, nodeSet.get(0));
                System.out.println("Success!");
            }else if(originalFileSize > compressedFileSize){
                System.out.println("Compressing...");
                hw.compressFile(textFile, resultFile, bitStringArray, nodeSet.get(0));
                System.out.println("Success!");
            }else{
                
            System.out.println("Your file will become larger after Huffman compression. If you insist, follow the instruction------------");
            System.out.println("Your input command line should expect to be called as follows:");
            System.out.println("java Huffman -c [-v] -f  infile outfile");
            System.out.println("where:");
            System.out.println("  -c stands for either -c (for compress)");
            System.out.println("  [-v] stands for an optional -v flag (for VerboseOutput)");
            System.out.println("  -f stands for an optional -f flag, that forces compression even if the compressed file will be larger than the original file");
            System.out.println("  infile is the input file");
            System.out.println("  outfile is the output file");
            System.out.println("The flags -f and -v can be in either order.  So, the following would all be doable:");
            System.out.println("  java Huffman -c -f  test test.huff");
            System.out.println("  java Huffman -c -f -v test test.huff");

            }
            
        }
        
        public int getFileSize(){
            return originalFileSize;
        }
        
        public void computeCompressedFileSize(){
            computeCompressedTree(nodeSet.get(0));
            compressedFileSize+=48;
            int size = 0;
            for(Character c : charFreq.keySet()){
                size = charFreq.get(c) * bitStringArray[c.hashCode()].length();
                compressedFileSize += size;
            }
            compressedFileSize+=(8 - (compressedFileSize%8));
        }
        
        public int getCompressedFileSize(){
            return compressedFileSize;
        }
        
        public void computeCompressedTree(TreeElem node){
            if(node == null){
                return;
            }
            
            if(node.getLeftChild() == null && node.getRightChild() == null){
                compressedFileSize = compressedFileSize + 9;
                return;
            }
            
            compressedFileSize+=1;
            computeCompressedTree(node.getLeftChild());
            computeCompressedTree(node.getRightChild());
            
        }
        
        public void createNodes(){
            for(Character c : charFreq.keySet()){
                
                TreeElem node = new TreeElem(c, charFreq.get(c));
                nodeSet.add(node);
                
            }
            Collections.sort(nodeSet);
            
            while(nodeSet.size() > 1){
                node = new TreeElem('.', (nodeSet.get(0).getF() + nodeSet.get(1).getF()));
                node.setLeftChild(nodeSet.get(0));
                node.setRightChild(nodeSet.get(1));
                nodeSet.remove(0);
                nodeSet.remove(0);
                nodeSet.add(node);
                Collections.sort(nodeSet);
                
            }
            
            String bitString = "";
            bitStringArray = new String[256];
            if(nodeSet.get(0).getLeftChild() == null && nodeSet.get(0).getRightChild() == null){
                bitStringArray[nodeSet.get(0).getValue().hashCode()] = "1";
                
            }else{
                createBitStrings(nodeSet.get(0), bitString);
            }
            
        }
        
        public void createBitStrings(TreeElem tree, String bitString){
            if (tree == null) return;
            if((tree.getLeftChild() != null)) createBitStrings(tree.getLeftChild(), bitString.concat("0"));
            if((tree.getRightChild() != null)) createBitStrings(tree.getRightChild(), bitString.concat("1"));
            if ((tree.getLeftChild() == null) && (tree.getRightChild() == null)){
                bitStringArray[tree.getValue().hashCode()] = bitString;
                return;
            }
        }
        
        public void VerboseOutput(){
            System.out.println("======================");
            System.out.println("Character Frequencies");
            System.out.println("====================== ");
            for(Character c : charFreq.keySet()){
                System.out.println("-----------------------------------");
                System.out.println("ASCII: " + c.hashCode() + " | Frequency: " + charFreq.get(c));
                System.out.println("-----------------------------------");
            }
            
            System.out.println("=====================");
            System.out.println("Huffman Tree");
            System.out.println("=====================");
            print(nodeSet.get(0), 1);
            
            System.out.println("======================");
            System.out.println("Huffman Codes");
            System.out.println("====================== ");
            
            for(int i = 0; i < bitStringArray.length; i++){
                if(!(bitStringArray[i] == null)){
                    System.out.println("-------------------------------------------");
                    System.out.println("ASCII: " + i + " " + " | Code: " + bitStringArray[i]);
                    System.out.println("-------------------------------------------");
                }
            }
            System.out.println("The size of the uncompressed file and the size of the compressed file");
            System.out.printf("Original Filesize: %d bits.%n", originalFileSize);
            System.out.printf("Original Filesize (in bytes): %d bytes.%n", originalFileSize/8);
            System.out.printf("Compressed FileSize: %d bits.%n",compressedFileSize);
            System.out.printf("Compressed FileSize (in bytes): %d bytes.%n",compressedFileSize/8);
            
        }
        
        private void print(TreeElem tree, int indent) {
            if (tree != null) {
                for(int i=0; i<indent; i++)
                    System.out.print("\t");
                System.out.println(tree.getValue() + " : " + tree.getF());
                print(tree.getLeftChild(), indent + 1);
                print(tree.getRightChild(), indent + 1);
            }
            
        }
        
    }
    static class TreeElem implements Comparable<TreeElem>{
        private int frequency;
        private Character value;
        private TreeElem leftChild, rightChild;
        public TreeElem(char value, int frequency){
            this.setValue(value);
            this.setFrequency(frequency);
        }
        public int getF() {
            return frequency;
        }
        public TreeElem getLeftChild() {
            return leftChild;
        }
        public void setLeftChild(TreeElem leftChild) {
            this.leftChild = leftChild;
        }
        public TreeElem getRightChild() {
            return rightChild;
        }
        public void setRightChild(TreeElem rightChild) {
            this.rightChild = rightChild;
        }
        public int compareTo(TreeElem arg0) {
            return this.getF() - arg0.getF();
        }
        public Character getValue() {
            return value;}
        public void setValue(char value) {
            this.value = value;
        }
        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }
    }
    
    static class ArrayList2<E> extends AbstractList<E>
    implements List<E>, RandomAccess, Cloneable, java.io.Serializable
    {
        
        private transient Object[] elementData;
        private static final Object[] EMPTY_ELEMENTDATA = {};
        private int size;
        public ArrayList2() {
            this(10);
        }
        public ArrayList2(int initialCapacity) {
                     if (initialCapacity > 0) {
                             this.elementData = new Object[initialCapacity];
                         } else if (initialCapacity == 0) {
                                 this.elementData = EMPTY_ELEMENTDATA;
                             } else {
                                     throw new IllegalArgumentException("Illegal Capacity: "+
                             initialCapacity);
                        }
                 }
        private void rangeCheck(int index) {
            if (index >= size)
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        private void rangeCheckForAdd(int index) {
            if (index > size || index < 0)
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        public void add(int index, E e) {
            rangeCheckForAdd(index);
            checkForComodification();
            parent.add(parentOffset + index, e);
            this.modCount = parent.modCount;
            this.size++;
        }
        public E remove(int index) {
            rangeCheck(index);
            checkForComodification();
            E result = parent.remove(parentOffset + index);
            this.modCount = parent.modCount;
            this.size--;
            return result;
        }
        @SuppressWarnings("unchecked")
        E elementData(int index) {
            return (E) elementData[index];
        }
        public E get(int index) {
            rangeCheck(index);
            
            return elementData(index);
        }
        private void checkForComodification() {
            if (ArrayList2.this.modCount != this.modCount)
                throw new ConcurrentModificationException();
        }
        private String outOfBoundsMsg(int index) {
                return "Index: "+index+", Size: "+size;
        }
        public List<E> subList(int fromIndex, int toIndex) {
        	subListRangeCheck(fromIndex, toIndex, size);
        	return new SubList(this, 0, fromIndex, toIndex);
        }
        static void subListRangeCheck(int fromIndex, int toIndex, int size) {
        	if (fromIndex < 0)
        		throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        	if (toIndex > size)
        		throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        	if (fromIndex > toIndex)
        		throw new IllegalArgumentException("fromIndex(" + fromIndex +
        		") > toIndex(" + toIndex + ")");
        }
        private class SubList extends AbstractList<E> implements RandomAccess {
            private final AbstractList<E> parent;
            private final int parentOffset;
            private final int offset;
            int size;
            SubList(AbstractList<E> parent,
                    int offset, int fromIndex, int toIndex) {
                this.parent = parent;
                this.parentOffset = fromIndex;
                this.offset = offset + fromIndex;
                this.size = toIndex - fromIndex;
                this.modCount = ArrayList2.this.modCount;
                        }
			@Override
			public E get(int index) {
				// TODO Auto-generated method stub
				rangeCheck(index);
				checkForComodification();
				return ArrayList2.this.elementData(offset + index);
				
			}
			@Override
			public int size() {
				// TODO Auto-generated method stub
				 checkForComodification();
				 return this.size;
			}
        }
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
    }
}
