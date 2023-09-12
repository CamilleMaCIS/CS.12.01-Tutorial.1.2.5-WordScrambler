public class WordScrambler {
    //instance variable
    private String[] scrambledWords;

    //constructor
    public WordScrambler(String[] wordArr) {
        //illegal argument: odd number of elements
        if (wordArr.length % 2 == 1){
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }
        //illegal argument: element contains more than one word
        for (String element : wordArr){
            if (element.contains(" ")){
                throw new IllegalArgumentException("Word Array must contain single words only! Attack on Titan contains more than one word!");
            }
        }
        scrambledWords = mixedWords(wordArr);
    }

    //method recombine
    private String recombine(String word1, String word2) {

        //if length = 6, goes from index 0 - 2
        //if length = 5, goes from index 0 - 1
        //remember, ending index is exclusive
        String half1 = word1.substring(0, word1.length()/2);

        //if length = 6, goes from index 3 - 5
        //if length = 5, goes from index 2 - 4, extra letter goes to second half
        String half2 = word2.substring(word2.length()/2);

        return half1 + half2;
    }

    //method mixedWords
    private String[] mixedWords(String[] words) {
        for (int i = 0; i < words.length; i+=2){
            String newWord1 = recombine(words[i], words[i+1]);
            String newWord2 = recombine(words[i+1], words[i]);
            words[i] = newWord1;
            words[i+1] = newWord2;
        }
        return words;
    }

    //getter method
    public String[] getScrambledWords(){
        return scrambledWords;
    }
}
