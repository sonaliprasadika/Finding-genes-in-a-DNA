public class Gean{

    public String findGean(String dna){
        String result ="";
        int startIndex = dna.indexOf("ATG");
        int currIndex = dna.indexOf("TAA", startIndex+3);

        while(currIndex != -1){
            if((currIndex - startIndex)%3 == 0){
                result = dna.substring(startIndex, currIndex+3);
                
                return result;
            }else{
                currIndex = dna.indexOf("TAA", currIndex);
            }
        }
        return "";
    }
    public static void main(String[] args){
        Gean g = new Gean();
        System.out.println(g.findGean("AATGCGTAAT TAATCG"));
        
    }
}