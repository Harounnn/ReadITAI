package com.example.readitai;

import com.ml.quaterion.text2summary.Text2Summary;

public class Summarizer {

    String text;

    public Summarizer(String text){
        this.text = text;
    }

    public String summarize(){
        System.out.println(text);
        String summary = Text2Summary.summarize(text, 0.9F);
        System.out.println(summary);
        return summary;
    }
}
