package project2;

/**
 * Huffman.java
 *
 * William H. Chuang
 * whchuang@usfca.edu
 *
 * Computer Science 245
 * This is Project 2: Huffman Coding.
 */
import java.io.*;
import java.util.*;
public class Huffman {
    public static void main(String[] args) {
        String fArray[] = new String[256];
        try {
            //The input parameter to the main function is an array of strings.
            /*for (String s: args) {
             System.out.println(s);
             }*/
            /* use constructor as if functional programming style*/
            CommandLineInputs cmdli = new CommandLineInputs(args);
            pseudo k = new pseudo(sign, args);
            if(!cmdli.hasOthers()){
                int Case = 0;//Compress
                if(k.isFunct("-u")) Case = 1;//unzip
                switch (Case) {
                    case 0: //Compress
                        HuffmanTree hufftree = new HuffmanTree(args[args.length - 2], args[args.length - 1]);
                        if(cmdli.pseudo.isFunct("-f")) hufftree.compinputTextFile("force");
                        else hufftree.compinputTextFile("");
                        if(cmdli.pseudo.isFunct("-v")) hufftree.VerboseOutput();//Verbose Output
                        break;
                    case 1: //unzip
                        if(cmdli.pseudo.isFunct("-u")){
                            print_hufftree prihufftee = new print_hufftree();
                            prihufftee.UnzipFile(args[args.length - 2], args[args.length - 1]);
                            if(cmdli.pseudo.isFunct("-v")) prihufftee.VerboseOutput();//Verbose Output
                            break;}}
            }
            else
            {
            instruction:
                System.out.println("/********************************************************************************************************/");
                System.out.println("* Your input command line should expect to be called as follows:");
                System.out.println("* java Huffman (-c|-u) [-v] [-f]  infile outfile");
                System.out.println("* where:");
                System.out.println("*   (-c|-u) stands for either -c (for compress), or -u (for uncompress)");
                System.out.println("*   [-v] stands for an optional -v sign (for VerboseOutput)");
                System.out.println("*   [-f] stands for an optional -f sign, that forces compression even if the compressed file will be larger than the original file");
                System.out.println("*   infile is the input file");
                System.out.println("*   outfile is the output file");
                System.out.println("* The signs -f and -v can be in either order.  So, the following would all be legal:");
                System.out.println("*   java Huffman -c test test.huff");
                System.out.println("*   java Huffman -c -v myTestFile myCompressedFile");
                System.out.println("*   java Huffman -c -f -v test test.huff");
                System.out.println("*   java Huffman -u -f test1.huff test2");
                System.out.println("*   java Huffman -u -f -v test1.huff test2");
                System.out.println("/********************************************************************************************************/");
            }
        } catch (Exception e) {
            System.out.println("/********************************************************************************************************/");
            System.err.println(" Caught Exception: " + e.getMessage());
            System.out.println("* Your input command line should expect to be called as follows:");
            System.out.println("* java Huffman (-c|-u) [-v] [-f]  infile outfile");
            System.out.println("* where:");
            System.out.println("*   (-c|-u) stands for either -c (for compress), or -u (for uncompress)");
            System.out.println("*   [-v] stands for an optional -v sign (for VerboseOutput)");
            System.out.println("*   [-f] stands for an optional -f sign, that forces compression even if the compressed file will be larger than the original file");
            System.out.println("*   infile is the input file");
            System.out.println("*   outfile is the output file");
            System.out.println("* The signs -f and -v can be in either order.  So, the following would all be legal:");
            System.out.println("*   java Huffman -c test test.huff");
            System.out.println("*   java Huffman -c -v myTestFile myCompressedFile");
            System.out.println("*   java Huffman -c -f -v test test.huff");
            System.out.println("*   java Huffman -u -f test1.huff test2");
            System.out.println("*   java Huffman -u -f -v test1.huff test2");
            System.out.println("/********************************************************************************************************/");
            System.exit(1);
        }
    }
    static class CommandLineInputs {
        private String[] args; //The input parameter to the main function is an array of strings.
        private Data<String, String> m = new Data<String, String>();
        //CommandLineInputs Constructor
        public CommandLineInputs(String[] args) {
            //for (String s: args) {
            //  System.out.println(s);
            //}
            this.args = args;
            if (args.length == 0) {
                System.out.println("/********************************************************************************************************/");
                System.out.println("* Entered the correct command line.");
                System.out.println("* Your input command line should expect to be called as follows:");
                System.out.println("* java Huffman (-c|-u) [-v] [-f]  infile outfile");
                System.out.println("* where:");
                System.out.println("*   (-c|-u) stands for either -c (for compress), or -u (for uncompress)");
                System.out.println("*   [-v] stands for an optional -v sign (for VerboseOutput)");
                System.out.println("*   [-f] stands for an optional -f sign, that forces compression even if the compressed file will be larger than the original file");
                System.out.println("*   infile is the input file");
                System.out.println("*   outfile is the output file");
                System.out.println("* The signs -f and -v can be in either order.  So, the following would all be legal:");
                System.out.println("*   java Huffman -c test test.huff");
                System.out.println("*   java Huffman -c -v myTestFile myCompressedFile");
                System.out.println("*   java Huffman -c -f -v test test.huff");
                System.out.println("*   java Huffman -u -f test1.huff test2");
                System.out.println("*   java Huffman -u -f -v test1.huff test2");
                System.out.println("/********************************************************************************************************/");
                System.exit(0);
                
            }
            for (int i = 0; i < args.length; i++) {
                plusthedata(args[i]);
            }
        }
        public boolean hasOthers() {
            int[] cmdCheck = { 0, 0, 0};
            String sign01="-c";
            String sign02="-u";
            String sign1="-v";
            String sign2="-f";
            for (int i = 0; i < args.length; i++) {
                if (sign01.equals(args[i])) {cmdCheck[0]++;}
                if (sign02.equals(args[i])) {cmdCheck[0]++;}
                if (sign1.equals(args[i])) {cmdCheck[1]++;}
                if (sign2.equals(args[i])) {cmdCheck[2]++;}
            }
            
            if(cmdCheck[0]==1&&cmdCheck[1]<=1&&cmdCheck[2]<=1&&args.length<=5)
                return false;
            else
                return true;
        }
        
        public void plusthedata(String sign) {
        	pseudo k = new pseudo(sign,args);
            if (sign.startsWith("-")&&k.isFunct(sign)&&hasValue(sign)) this.m.put(sign, getValue(sign));
            else this.m.put(sign, "");
        }
        
        
        
        public boolean hasValue(String sign) {
            for (int i = 0; i < args.length; i++)
                if (sign.equals(args[i])&& i < args.length - 1 && !args[i + 1].startsWith("-")) return true;
            return false;
        }
        
        public String getValue(String sign) {
            String value = "";
            if (hasValue(sign))
                for (int i = 0; i < args.length; i++) if (sign.equals(args[i])) value = args[i + 1];
            return value;
        }
        
        public int numsigns() {
            int signCount = 0;
            for (String s : this.args)
                if (s.startsWith("-"))signCount++;
            return signCount;
        }
        
        public int numArguments() {
            int counter_01 = 0;
            for (String s : this.args)
                if (s.startsWith("-")&&hasValue(s)) ++counter_01;
            return counter_01;
        }
    }
    static class pseudo{
        String sign;
        String[] args;
        public pseudo(String sign, String[] args){
            this.sign=sign;
            this.args=args;
            
        }
        public boolean isFunct(String sign) {
        	
            int s=0;
            while (s<args.length)
            {
                if (sign.equals(args[s]))
                    return true;
                s++;
            }
            return false;
        }
    }
    static class print_hufftree {
        private BinaryFile result, input;
        private TextFile text;//The constructor takes two arguments -- the name of the text file, and a single character.  To open a text file for reading, pass in the character 'r' or 'R'.  To open a text file for writing, pass in the character 'w' or 'W'
        private TreeElem child;
        //Encoding File: in binary
        public void compressFile(String inputFile, String resultFile, String[] codeArray, TreeElem child){
            File file = new File(resultFile);
            file.delete();
            result = new BinaryFile(resultFile, 'w');
            //The constructor takes two arguments -- the name of the text file, and a single character.  To open a text file for reading, pass in the character 'r' or 'R'.  To open a text file for writing, pass in the character 'w' or 'W'
            text  = new TextFile(inputFile, 'r');
            
            /*Magic Numbers
             Goal: to try to uncompress files that you actually compressed yourself. To help ensure this, you will write a "Magic Number" to the first 16 bits of the output file. When uncompressing a file, first read in these 16 bits and make sure that they match the magic number. If not, your program should print out an error message and not try to decompress the file. The "Magic Number" that you should use is 0x4846 (that is, the ASCII characeters HF).*/
            
            result.writeChar('H');//This method can only be called for output files.  The character c is written to the output file
            result.writeChar('F');
            TreeSerialization(child);
            Character c;
            //The EndOfFile method can only be called for input files.  It returns true if the entire file has been read, and false otherwise.
            
            while(!text.EndOfFile()){
                //public char readChar() This method can only be called for input files.  The next character (next 8 bits in the input file) is read and returned
                c = text.readChar();
                String s = codeArray[c.hashCode()];
                for(int i = 0; i < s.length(); i++){
                    if(s.charAt(i) == '1')result.writeBit(true);//The writeBit method can only be called for output files.  A single bit is written to the output file.
                    else result.writeBit(false);
                }
            }
            //Don't forget to close the result file when you are done...
            result.close();//Close the temp file.  Call the close method when you are done with the file.  If the close method is not called, output files will not be written out correctly
        }

        
        //Reads in the inputfile(Huffman encoded file) and writes out the decoded file to resultFile
        public void UnzipFile(String inputFile, String resultFile){
            File file = new File(resultFile);
            file.delete();
            //The constructor takes two arguments -- the name of the text file, and a single character.  To open a text file for reading, pass in the character 'r' or 'R'.  To open a text file for writing, pass in the character 'w' or 'W'
            text = new TextFile(resultFile, 'w');
            input = new BinaryFile(inputFile, 'r');
            int i = 1;
            String s = "";
            while(i < 3){
                //public char readChar() This method can only be called for input files.  The next character (next 8 bits in the input file) is read and returned
              

                Character c = input.readChar();
                s = s.concat(c.toString());
                i++;
            }
            //Magic Numbers check
            if(s.equals("HF")){
                System.out.println("/********************************************************************************************************/");
                System.out.println("* Unziping...");
                if(input.readBit() == false){
                    child  = new TreeElem(' ', 0);
                    child.setLeftChild(rebuildTree());
                    child.setRightChild(rebuildTree());
                    
                }else{
                    //public char readChar() This method can only be called for input files.  The next character (next 8 bits in the input file) is read and returned
                    child = new TreeElem(input.readChar(), 0);
                }
                //The EndOfFile method can only be called for input files.  It returns true if the entire file has been read, and false otherwise.
                /*Reading Huffman Tree
                 To read in the Huffman tree, we do a preorder traversal of the tree -- guided by the input file -- creating nodes as we go.*/
                while(!input.EndOfFile()){
                    if(child.leftchild() == null && child.rightsib() == null){
                        text.writeChar(child.getValue());//This method can only be called for output files.  The character c is written to the output file
                        input.readBit();
                    }
                    else treeTraversals(child);
                }
                text.close();//Close the temp file.  Call the close method when you are done with the file.  If the close method is not called, output files will not be written out correctly
                System.out.println("* Success!");
                System.out.println("/********************************************************************************************************/");
            }else{
                System.out.println("/********************************************************************************************************/");
                System.out.println("* Failed to Unzip your input file...!");
                System.out.println("/********************************************************************************************************/");
            }
        }

        
        public TreeElem rebuildTree(){
            if(input.readBit() == true){
                //public char readChar() This method can only be called for input files.  The next character (next 8 bits in the input file) is read and returned
                TreeElem n = new TreeElem(input.readChar(), 0);
                return n;
            }
            TreeElem child = new TreeElem(' ', 0);
            child.setLeftChild(rebuildTree());
            child.setRightChild(rebuildTree());
            return child;
        }
//Verbose Output
        public void VerboseOutput(){
            //The Huffman tree (see class notes on printing trees for pointers on how this can be done)
            System.out.println("/********************************************************************************************************/");
            System.out.println("* This is Huffman Tree!!");
            System.out.println("/********************************************************************************************************/");
            print(child, 1);
            System.out.println("/********************************************************************************************************/");
            System.out.println("* So, you got your Huffman Tree!");
            System.out.println("/********************************************************************************************************/");
        }
        private void print(TreeElem tree, int indent) {
            if (tree != null) {
                for(int i=0; i<indent; i++)
                    System.out.print("\t");
                System.out.println(tree.getValue() + " | " + tree.getF());
                print(tree.leftchild(), indent + 1);
                print(tree.rightsib(), indent + 1);
            }
        }
        public void treeTraversals(TreeElem child){
            if(child.leftchild() == null && child.rightsib() == null){
                /*Goal: Decoding File
                 Once the tree has been built, decoding files is easy.  Start from the root of the tree, follow the appropriate child based on the next bit read in from the input file until a leaf is reached, and then print out the character stored at that leaf.*/
                text.writeChar(child.getValue());
                //This writeChar method can only be called for output files.  The character c is written to the output file
                return;
            }
            if(input.readBit() == false){treeTraversals(child.leftchild());}
            else treeTraversals(child.rightsib());
        }
        //Writes the huffman tree out in binary to the specified file
        public void TreeSerialization(TreeElem tree){
            if (tree == null) return;
            if ((tree.leftchild() == null) && (tree.rightsib() == null)){
                //The writeBit method can only be called for output files.  A single bit is written to the output file.
                result.writeBit(true);
                result.writeChar(tree.getValue());//This method can only be called for output files.  The character c is written to the output file
                return;}
            result.writeBit(false);
            TreeSerialization(tree.leftchild());
            TreeSerialization(tree.rightsib());
        }
    }
//Building Huffman Trees and tables
    static class HuffmanTree {
        public int numb_bits_of_file(){return bytes_of_unzipInput;}
        private array<TreeElem> childSet;
        private print_hufftree hu;
        private TextFile text;//The constructor takes two arguments -- the name of the text file, and a single character.  To open a text file for reading, pass in the character 'r' or 'R'.  To open a text file for writing, pass in the character 'w' or 'W'
        private Data<Character, Integer> frequency_of_char;
        private String textFile, resultFile;
        private TreeElem child;
        private String[] Array_of_String_in_bits_rep;
        private int bytes_of_unzipInput, zippedsize;
        public HuffmanTree(String textFile, String resultFile){
            frequency_of_char = new Data<Character, Integer>();
            childSet = new array<TreeElem>();
            this.textFile = textFile;
            hu = new print_hufftree();
            this.resultFile = resultFile;
        }
        public void compinputTextFile(String sign){
            text = new TextFile(textFile, 'r');//The constructor takes two arguments -- the name of the text file, and a single character.  To open a text file for reading, pass in the character 'r' or 'R'.  To open a text file for writing, pass in the character 'w' or 'W'
            bytes_of_unzipInput = 0;
            System.out.println("/********************************************************************************************************/");
            System.out.println("* Your input file is loading...");
            System.out.println("/********************************************************************************************************/");
            //The EndOfFile method can only be called for input files.  It returns true if the entire file has been read, and false otherwise.
            while(!text.EndOfFile()){
                //public char readChar() This method can only be called for input files.  The next character (next 8 bits in the input file) is read and returned
                char c = text.readChar();
                bytes_of_unzipInput++;//got unzip file size
                if(frequency_of_char.containsKey(c))frequency_of_char.put(c, frequency_of_char.get(c) + 1);
                else frequency_of_char.put(c, 1);
            }
            /**
             * The size of the uncompressed file (in bits):
             * (# of characters in the input file) * 8
             */
            bytes_of_unzipInput = bytes_of_unzipInput * 8;
            createchilds();
            zipbytes();
            text.rewind();//This method can only be called for input files.  The file is rewound to the beginning (useful for encoding the file, after it has been read in to determine frequency information)
            if(sign.equals("force")){
                System.out.println("/********************************************************************************************************/");
                System.out.println("* Compressing...");
                hu.compressFile(textFile, resultFile, Array_of_String_in_bits_rep, childSet.get(0));
                System.out.println("* Success!");
            }else if(bytes_of_unzipInput > zippedsize){
                System.out.println("/********************************************************************************************************/");
                System.out.println("* Compressing...");
                hu.compressFile(textFile, resultFile, Array_of_String_in_bits_rep, childSet.get(0));
                System.out.println("* Success!");
                System.out.println("/********************************************************************************************************/");
            }else{
                System.out.println("/********************************************************************************************************/");
                System.out.println("* Your file will become larger after Huffman compression. If you insist, follow the instruction------------");
                System.out.println("* Your input command line should expect to be called as follows:");
                System.out.println("* java Huffman -c [-v] -f  infile outfile");
                System.out.println("* where:");
                System.out.println("*   -c stands for either -c (for compress)");
                System.out.println("*   [-v] stands for an optional -v sign (for VerboseOutput)");
                System.out.println("*   -f stands for an optional -f sign, that forces compression even if the compressed file will be larger than the original file");
                System.out.println("*   infile is the input file");
                System.out.println("*   outfile is the output file");
                System.out.println("* The signs -f and -v can be in either order.  So, the following would all be doable:");
                System.out.println("*   java Huffman -c -f  test test.huff");
                System.out.println("*   java Huffman -c -f -v test test.huff");
                System.out.println("/********************************************************************************************************/");
            }
        }
        public void zipbytes(){
            ZippedTree(childSet.get(0));
            zippedsize+=48;
            int size = 0;
            for(Character c : frequency_of_char.keySet()){
                size = frequency_of_char.get(c) * Array_of_String_in_bits_rep[c.hashCode()].length();
                zippedsize += size;
            }
            zippedsize+=(8 - (zippedsize%8));
        }
        public int getzippedsize(){
            return zippedsize;
            /**
             * Size of the compressed file (in bits)
             * Add up:
             * For each character c in the input file, (frequency of c) * size of the encoding for c
             * Size of the tree (1 bit for each internal node, 9 bits for each leaf
             * An extra 2 bytes (16 bits) for the magic number
             * An extra 4 bytes (32 bits) for header information used in the BinaryFile class
             * Note that the compressed file size needs to be a multiple of 8 bits -- so if the calculated binary file size is 457 bits, the file will actually be 464 bits long
             */
        }
        
        public void ZippedTree(TreeElem child){
            if(child == null) return;
            if(child.leftchild() == null && child.rightsib() == null){
                zippedsize = zippedsize + 9;
                return;
            }
            zippedsize+=1;
            ZippedTree(child.leftchild());
            ZippedTree(child.rightsib());
        }
        
        public void createchilds(){
            for(Character c : frequency_of_char.keySet()){
                TreeElem child = new TreeElem(c, frequency_of_char.get(c));
                childSet.add(child);
            }
            Collections.sort(childSet);
            while(childSet.size() > 1){
                child = new TreeElem(' ', (childSet.get(0).getF() + childSet.get(1).getF()));
                child.setLeftChild(childSet.get(0));
                child.setRightChild(childSet.get(1));
                childSet.remove(0);
                childSet.remove(0);
                childSet.add(child);
                Collections.sort(childSet);
            }
            String bitString = "";
            Array_of_String_in_bits_rep = new String[256];
            if(childSet.get(0).leftchild() == null && childSet.get(0).rightsib() == null){
                Array_of_String_in_bits_rep[childSet.get(0).getValue().hashCode()] = "1";
            }else{
                createBitStrings(childSet.get(0), bitString);
            }
        }
        public void createBitStrings(TreeElem tree, String bitString){
            if (tree == null) return;
            if((tree.leftchild() != null)) createBitStrings(tree.leftchild(), bitString.concat("0"));
            if((tree.rightsib() != null)) createBitStrings(tree.rightsib(), bitString.concat("1"));
            if ((tree.leftchild() == null) && (tree.rightsib() == null)){
                Array_of_String_in_bits_rep[tree.getValue().hashCode()] = bitString;
                return;
            }
        }
//If a file is uncompressed with the "-v" option, you should print out following to standard output (using System.out.print(ln)):

//Verbose Output
        //The frequency of each character in the input file (print the ASCII values of the characters, instead of the characters themselves, to make this more readable for binary files)
        public void VerboseOutput(){
            System.out.println("/********************************************************************************************************/");
            System.out.println("* The frequency of each character in the input file (print the ASCII values of the characters");
            System.out.println("/********************************************************************************************************/");
            for(Character c : frequency_of_char.keySet()){
                //The frequency of each character in the input file (print the ASCII values of the characters, instead of the characters themselves, to make this more readable for binary files)
                System.out.println("/********************************************************************************************************/");
                System.out.println("* Ascii code: " + c.hashCode() );
                System.out.println("Frequency: " + frequency_of_char.get(c));
                System.out.println("/********************************************************************************************************/");
            }
            //The Huffman tree (see class notes on printing trees for pointers on how this can be done)
            //
            System.out.println("/********************************************************************************************************/");
            System.out.println("* Huffman Tree");
            System.out.printf("* If it a leaf, then print the corresponding symbol instead. %n");
            System.out.println("/********************************************************************************************************/");
            print(childSet.get(0), 1);
            //The Huffman codes for each character that has a code (characters which do not appear in the input file will not have codes.  Again, print the ASCII values of characters instead of the characters themselves)
            System.out.println("/********************************************************************************************************/");
            System.out.println("* Huffman Codes");
            System.out.println("/********************************************************************************************************/");
            
            for(int i = 0; i < Array_of_String_in_bits_rep.length; ++i){
                if(!(Array_of_String_in_bits_rep[i] == null)){
                    System.out.println("/********************************************************************************************************/");
                    System.out.println("* Ascii code: " + i + "                                                                                       *");
                    System.out.println("* Encoded as: " + Array_of_String_in_bits_rep[i]);
                    System.out.println("/********************************************************************************************************/");
                }
            }
            System.out.println("/********************************************************************************************************/");
            System.out.println("* The size of the uncompressed file and the size of the compressed file");
            System.out.printf("* Original Filesize: %d bits.%n", bytes_of_unzipInput);
            System.out.printf("* Original Filesize (in bytes): %d bytes.%n", bytes_of_unzipInput/8);
            System.out.printf("* Compressed FileSize: %d bits.%n",zippedsize);
            System.out.printf("* Compressed FileSize (in bytes): %d bytes.%n",zippedsize/8);
            System.out.println("/********************************************************************************************************/");
        }
        //Reference is athttps://www.cs.usfca.edu/~galles/cs245/lecture/GenTreeOpsSol.java
        private void print(TreeElem tree, int offset) {
            if (tree != null) {
                for(int i=0; i<offset; i++)
                    System.out.print("\t");
                System.out.println( ""+ tree.getValue()+ " | " + tree.getF());
                print(tree.leftchild(), offset + 1);
                print(tree.rightsib(), offset + 1);
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
        public int getF() {return frequency;}
        public TreeElem leftchild() {return leftChild;}
        public void setLeftChild(TreeElem leftChild) {this.leftChild = leftChild;}
        public TreeElem rightsib() {return rightChild;}
        public void setRightChild(TreeElem rightChild) {this.rightChild = rightChild;}
        public int compareTo(TreeElem arg0) {return this.getF() - arg0.getF();}
        public Character getValue() {return value;}
        public void setValue(char value) {this.value = value;}
        public void setFrequency(int frequency){this.frequency = frequency;}
    }
    static class array<E> extends AbstractList<E>{
        private transient Object[] nodeData;
        private int size;
        public array(int initSize) {
            super();
            this.nodeData = new Object[initSize];
        }
        public array() {
            this(10);
        }
        private void ensurestore_sizeInternal(int infsize) {
            modCount++;
            // overflow-conscious code
            if (infsize - nodeData.length > 0)
                grow(infsize);
        }
        private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
        private void grow(int infsize) {
            // overflow-conscious code
            int oldstore_size = nodeData.length;
            int newstore_size = oldstore_size + (oldstore_size >> 1);
            if (newstore_size - infsize < 0)
                newstore_size = infsize;
            if (newstore_size - MAX_ARRAY_SIZE > 0)
                newstore_size = hugestore_size(infsize);
            // infsize is usually close to size, so this is a win:
            nodeData = Arrays.copyOf(nodeData, newstore_size);
        }
        private static int hugestore_size(int infsize) {
            if (infsize < 0) // overflow
                throw new OutOfMemoryError();
            return (infsize > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
        }
        public int size() {
            return size;
        }
        @SuppressWarnings("unchecked")
        E nodeData(int index) {return (E) nodeData[index];}
        public E get(int index) {return nodeData(index);}
        public E set(int index, E node) {
            E old = nodeData(index);
            nodeData[index] = node;
            return old;}
        public void add(int index, E node) {
            ensurestore_sizeInternal(size + 1);
            System.arraycopy(nodeData, index, nodeData, index + 1,size - index);
            nodeData[index] = node;
            size++;}
        public E remove(int index) {
            modCount++;
            E old = nodeData(index);
            int numMoved = size - index - 1;
            if (numMoved > 0) System.arraycopy(nodeData, index+1, nodeData, index, numMoved);
            nodeData[--size] = null;
            return old;}
        private String outOfBoundsMsg(int index) {return "";}
    }
    @SuppressWarnings({"unchecked", "unsafe"})
    static class Data<K,V> extends AbstractMap<K,V>{
        public int hashCode2() {
            int h = 0;
            Iterator<java.util.Map.Entry<K, V>> i = entrySet().iterator();
            while (i.hasNext()) h += i.next().hashCode();
            return h;}
        //The default initial store_size - MUST be a power of two.
        static final int CAP = 16;
        //The maximum store_size
        static final int MCAP = 1 << 30;
        static final float defaultinput = 0.75f;
        //The arrayforinput, resized as necessary. Length MUST Always be a power of two.
        transient Entry[] arrayforinput;
        transient int size;
        int bdy;
        final float loadinput;
        transient int modCount;
        public Data(int initSize, float loadinput) {
            if (initSize > MCAP)
                initSize = MCAP;
            int store_size = 1;
            while (store_size < initSize)
                store_size <<= 1;
            this.loadinput = loadinput;
            bdy = (int)(store_size * loadinput);
            arrayforinput = new Entry[store_size];
            init();}
        public Data(int initSize) {
            this(initSize, defaultinput);
        }
        public Data() {
            this.loadinput = defaultinput;
            bdy = (int)(CAP * defaultinput);
            arrayforinput = new Entry[CAP];
            init();
        }
        public boolean containsKey(Object key) {return getEntry(key) != null;}
        final Entry<K,V> getEntry(Object key) {return null;}
        void init() {}
        static int hash(int h) {h ^= (h >>> 20) ^ (h >>> 12);return h ^ (h >>> 7) ^ (h >>> 4);}
        static int indexFor(int h, int length) {return h & (length-1);}
        public int size() {return size;}
        public V get(Object key) {
            if (key == null)
            {
                for (Entry<K,V> e = arrayforinput[0]; e != null; e = e.next) {
                    if (e.key == null)
                        return e.value;
                }
                return null;
            }
            int hash = hash(key.hashCode());
            for (Entry<K,V> e = arrayforinput[indexFor(hash, arrayforinput.length)];
                 e != null;
                 e = e.next) {
                Object k;
                if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
                    return e.value;
            }
            return null;
        }
        public V put(K key, V value) {
            if (key == null)
                return putForNullKey(value);
            int hash = hash(key.hashCode());
            int i = indexFor(hash, arrayforinput.length);
            for (Entry<K,V> e = arrayforinput[i]; e != null; e = e.next) {
                Object k;
                if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                    V old = e.value;
                    e.value = value;
                    return old;}}
            modCount++;
            addEntry(hash, key, value, i);
            return null;
        }
        private V putForNullKey(V value) {
            for (Entry<K,V> e = arrayforinput[0]; e != null; e = e.next) {
                if (e.key == null) {
                    V old = e.value;
                    e.value = value;
                    return old;
                }
            }
            modCount++;
            addEntry(0, null, value, 0);
            return null;
        }
        void resize(int newstore_size) {
            Entry[] oldarrayforinput = arrayforinput;
            int oldstore_size = oldarrayforinput.length;
            if (oldstore_size == MCAP) {
                bdy = Integer.MAX_VALUE;
                return;
            }
            Entry[] newarrayforinput = new Entry[newstore_size];
            Entry[] src = arrayforinput;
            newstore_size = newarrayforinput.length;
            for (int j = 0; j < src.length; j++) {
                Entry<K,V> e = src[j];
                if (e != null) {
                    src[j] = null;
                    do {
                        Entry<K,V> next = e.next;
                        int i = indexFor(e.hash, newstore_size);
                        e.next = newarrayforinput[i];
                        newarrayforinput[i] = e;
                        e = next;
                    } while (e != null);}}
            arrayforinput = newarrayforinput;
            bdy = (int)(newstore_size * loadinput);
        }
        public void putAll(Map<? extends K, ? extends V> m) {
            int scalar = m.size();
            for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
                put(e.getKey(), e.getValue());
        }
        public V remove(Object key) {
            Entry<K,V> e = removeEntryForKey(key);
            return (e == null ? null : e.value);
        }
        final Entry<K,V> removeEntryForKey(Object key) {
            int hash = (key == null) ? 0 : hash(key.hashCode());
            int i = indexFor(hash, arrayforinput.length);
            Entry<K,V> prev = arrayforinput[i];
            Entry<K,V> e = prev;
            while (e != null) {
                Entry<K,V> next = e.next;
                Object k;
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k)))) {
                    modCount++;
                    size--;
                    return e;
                }
                prev = e;
                e = next;
            }
            return e;
        }
        public void clear() {
            modCount++;
            Entry[] littlearray = arrayforinput;
            for (int i = 0; i < littlearray.length; i++)
                littlearray[i] = null;
            size = 0;
        }
        public boolean containsValue(Object value) {
            if (value == null)
            {
                Entry[] littlearray = arrayforinput;
                for (int i = 0; i < littlearray.length ; i++)
                    for (Entry e = littlearray[i] ; e != null ; e = e.next)
                        if (e.value == null)
                            return true;
                return false;
            }
            Entry[] littlearray = arrayforinput;
            for (int i = 0; i < littlearray.length ; i++)
                for (Entry e = littlearray[i] ; e != null ; e = e.next)
                    if (value.equals(e.value))
                        return true;
            return false;
        }
        static class Entry<K,V> implements Map.Entry<K,V> {
            final K key;
            V value;
            Entry<K,V> next;
            final int hash;
            //new entry
            Entry(int h, K k, V v, Entry<K,V> n) {
                value = v;
                next = n;
                key = k;
                hash = h;
            }
            public final K getKey() {return key;}
            public final V getValue() {return value;}
            public final V setValue(V newValue) {
                V old = value;
                value = newValue;
                return old;}
        }
        void addEntry(int hash, K key, V value, int bucketIndex) {
            Entry<K,V> e = arrayforinput[bucketIndex];
            arrayforinput[bucketIndex] = new Entry<>(hash, key, value, e);
            if (size++ >= bdy)resize(2 * arrayforinput.length);
        }
        void createEntry(int hash, K key, V value, int bucketIndex) {
            Entry<K,V> e = arrayforinput[bucketIndex];
            arrayforinput[bucketIndex] = new Entry<>(hash, key, value, e);
            size++;
        }
        private abstract class HashIterator<E> implements Iterator<E> {
            Entry<K,V> next;        // next entry to return
            int expectedModCount;   // For fast-fail
            int index;              // temp slot
            Entry<K,V> temp;     // temp entry
            HashIterator() {
                expectedModCount = modCount;
                if (size > 0) { // advance to first entry
                    Entry[] t = arrayforinput;
                    while (index < t.length && (next = t[index++]) == null);
                }
            }
            public final boolean hasNext() {return next != null;}
            final Entry<K,V> nextEntry() {
                Entry<K,V> e = next;
                if ((next = e.next) == null) {
                    Entry[] t = arrayforinput;
                    while (index < t.length && (next = t[index++]) == null);
                }
                temp = e;
                return e;
            }
            public void remove() {
                Object k = temp.key;
                temp = null;
                Data.this.removeEntryForKey(k);
                expectedModCount = modCount;
            }
        }
        private final class ValueIterator extends HashIterator<V> {public V next() {return nextEntry().value;}}
        private final class KeyIterator extends HashIterator<K> {public K next() {return nextEntry().getKey();}}
        private final class EntryIterator extends HashIterator<Map.Entry<K,V>> {
            public Map.Entry<K,V> next() {return nextEntry();}}
        Iterator<K> newKeyIterator() {return new KeyIterator();}
        Iterator<V> newValueIterator() {return new ValueIterator();}
        private transient Set<Map.Entry<K,V>> entrySet = null;
        private final class KeySet extends AbstractSet<K> {
            public Iterator<K> iterator() {return newKeyIterator();}
            public int size() {return size;}
            public boolean contains(Object o) {return containsKey(o);}
            public boolean remove(Object o) {return Data.this.removeEntryForKey(o) != null;}
            public void clear() {}
        }
        private final class Values extends AbstractCollection<V> {
            public Iterator<V> iterator() {return newValueIterator();}
            public int size() {return size;}
            public boolean contains(Object o) {return containsValue(o);}
            public void clear() {}
        }
        @Override
        public Set<K> keySet() {
            Data<K, V>.KeySet keySet = null;
            Set<K> ks = keySet;
            return (ks != null ? ks : (keySet = new KeySet()));
        }
        @Override
        public Collection<V> values() {
            Collection<V> values = null;
            Collection<V> vs = values;
            return (vs != null ? vs : (values = new Values()));
        }
        @Override
        public Set<Map.Entry<K,V>> entrySet() {
            return entrySet();
        }
    }
}
/*Due Date
This project is due at Midnight on Monday, March 23rd. The project may be turned in after Monday, but by Wednesday March 25th at Midnight for 75% credit.  Projects turned in after Midnight on March 25th will receive no credit.
 Program Submission & Environment
 
 
 You need to submit an electronic version of your code.  To submit electronically, submit the file Huffman.java (as well as all other source files that your program needs to run, including the provided files for file I/O) to the subversion repository:
 
 athttps://www.cs.usfca.edu/svn/<username>/cs245/Project2
 
 
 You may develop your code in any environment that you like, but it needs to run under linux in the labs!  While I recommend developing under linux, you may develop in Windows if you prefer, as long as your program runs under linux.  To compile and run your program in linux, create a directory that contains all of the necessary .java files.  Then compile all the files with the command
 
 % javac *.java
 
 You can then run you program with the command:
 
 % java Huffman -c <input file> <output file>
 
 Collaboration
 
 It is OK for you to discuss solutions to this program with your classmates.  However, no collaboration should ever involve looking at one of your classmate's source programs!  It is usually extremely easy to determine that
 someone has copied a program, even when the individual doing the copying has changed identifier names and comments.
 Supporing Files
 
 1. BinaryFile.java
 2. TextFile.java
 3. Assert.java (Used by BinaryFile and TextFile clases)
 4. Javadocs for Provided Classes
 
*/

/*Reference: 
athttps://www.cs.usfca.edu/~galles/cs245/huffman/
*/