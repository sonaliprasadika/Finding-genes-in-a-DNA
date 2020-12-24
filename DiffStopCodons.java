public class DiffStopCodons{

    public int findStopCodon(String dna, int startIndex, String stopCodon){
        // current index after finding start index (startIndex+3)
        int currIndex = dna.indexOf(stopCodon, startIndex+3);

        while(currIndex != -1){
            if((currIndex - startIndex)%3 == 0){
                return currIndex;
            }else{
                // for finding next stop codon string
                currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        return dna.length();
    }

    // find the gene from all 3 types, find the first appears one
    public String findGean(String dna){
        String result ="";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");

        int minIndex = 0;
        if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
            minIndex = tgaIndex;
        }

        if(minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)){
            minIndex = tagIndex;
        }

        if(minIndex == -1){
            return "";
        }
        return dna.substring(startIndex, minIndex+3);
    }
    // test cases for find stop
    public void testFindStop(){
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna, 0, "TAA");
        if(dex != 9) System.out.println("error on 9");
        dex = findStopCodon(dna, 9, "TAA");
        if(dex != 21) System.out.println("error on 21");
        dex = findStopCodon(dna, 1, "TAA");
        if(dex != -1) System.out.println("error on 26");
        dex = findStopCodon(dna, 0, "TAA");
        if(dex != -1) System.out.println("error on 26");
        System.out.println("Test finished!");
    }
    // test cases for find gene
    public void testFindGene(){
        String dna = "ATGCCCGGGAAATAACCC";
        String gene = findGean(dna);
        if(!gene.equals("ATGCCCGGGAAATAA")){
            System.out.println("ERROR");
        }
        System.out.println("Test finished!");
    }

    public static void main(String[] args){
        DiffStopCodons g = new DiffStopCodons();
        System.out.println(g.findGean("AATGCGTAATTAATCG"));
        g.testFindGene();
        g.testFindStop();
        
    }
}