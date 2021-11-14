package sample.model;

import java.util.ArrayList;
import java.util.List;

public class Word {

    String word;
    List<Tense> tenses = new ArrayList<>();

    public Word(String word, List<Tense> tenses) {
        this.word = word;
        this.tenses = tenses;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Tense> getTenses() {
        return tenses;
    }

    public void setTenses(List<Tense> tenses) {
        this.tenses = tenses;
    }

    static class Tense {
        String tense;
        List<Conjugation> conjugations = new ArrayList<>();

        public Tense(String tense, List<Conjugation> conjugations) {
            this.tense = tense;
            this.conjugations = conjugations;
        }

        public Tense(String tense) {
            this.tense = tense;
        }

        public String getTense() {
            return tense;
        }

        public void setTense(String tense) {
            this.tense = tense;
        }

        public List<Conjugation> getConjugations() {
            return conjugations;
        }

        public void setConjugations(List<Conjugation> conjugations) {
            this.conjugations = conjugations;
        }
    }

    static class Conjugation{

        String conjugation;
        List<Sentences> sentences = new ArrayList<>();

        public Conjugation(String conjugation, List<Sentences> sentences) {
            this.conjugation = conjugation;
            this.sentences = sentences;
        }

        public String getConjugation() {
            return conjugation;
        }

        public void setConjugation(String conjugation) {
            this.conjugation = conjugation;
        }

        public List<Sentences> getSentences() {
            return sentences;
        }

        public void setSentences(List<Sentences> sentences) {
            this.sentences = sentences;
        }
    }

    static class Sentences{

        String sentence;

        public Sentences(String sentence) {
            this.sentence = sentence;
        }

        public String getSentence() {
            return sentence;
        }

        public void setSentence(String sentence) {
            this.sentence = sentence;
        }
    }



}
