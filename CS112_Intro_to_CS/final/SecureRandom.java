import java.security.SecureRandom;
SecureRandom random = SecureRandom.getInstance("SHA1PRNG"); 
random.setSeed(seed); 
int randInt = random.nextInt(maxvalue);