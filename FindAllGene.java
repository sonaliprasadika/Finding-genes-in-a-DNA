public class FindAllGene{

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
    public String findGean(String dna,int where){
        String result ="";
        int startIndex = dna.indexOf("ATG", where);
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

    public void printAllGenes(String dna){
        int startIndex = 0;

        while(true){
            // find the next gene after startIndex
            String currentGene = findGean(dna, startIndex);
            // If no gene was found, leave this loop
            if(currentGene.isEmpty()){
                break;
            }
            // print the gene out
            System.out.println(currentGene);
            // Set startIndex to just past the end of the gene
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();

        }
    }
    
    public void testOn(String dna){
        System.out.println("Testing printAllGenes on " + dna);
        printAllGenes(dna);

    }

    public void test(){
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");

        testOn("ATGATCATAAGATAATAGAGGGCCATGTAA");
    }
    public static void main(String[] args){
        FindAllGene g = new FindAllGene();
        g.test();
       
      
    }
}