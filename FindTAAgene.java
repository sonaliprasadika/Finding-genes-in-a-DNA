public class FindTAAgene{

    public String findGean(String dna){
        String result ="";
        int startIndex = dna.indexOf("ATG");
        // current index after finding start index (startIndex+3)
        int currIndex = dna.indexOf("TAA", startIndex+3);

        while(currIndex != -1){
            // check it's divided by3
            if((currIndex - startIndex)%3 == 0){
                result = dna.substring(startIndex, currIndex+3);
                
                return result;
            }else{
                // for finding next TAA string
                currIndex = dna.indexOf("TAA", currIndex+1);
            }
        }
        return "";
    }
    public static void main(String[] args){
        FindTAAgene g = new FindTAAgene();
        System.out.println(g.findGean("AATGCGTAATTAATCG"));
        
    }
}