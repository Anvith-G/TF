package com.example.talkingfingers;

import android.content.Context;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.util.Span;
import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class NlpProcessor {

    // Declare posTagger as a class member
    private POSTaggerME posTagger;

    public NlpProcessor(Context context) throws IOException {
        // Load POS model
        InputStream posModelIn = context.getAssets().open("en-pos-maxent.bin");
        POSModel posModel = new POSModel(posModelIn);
        posTagger = new POSTaggerME(posModel);
    }

    public static List<String> tokenizeText(String text) {
        SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
        return List.of(tokenizer.tokenize(text));
    }

    public List<String> chunkText(Context context, String text) throws IOException {
        // Load Chunker model
        InputStream modelIn = context.getAssets().open("en-chunker.bin");
        ChunkerModel chunkerModel = new ChunkerModel(modelIn);
        ChunkerME chunker = new ChunkerME(chunkerModel);

        // Tokenize the sentence
        String[] tokens = SimpleTokenizer.INSTANCE.tokenize(text);

        // Tag the sentence using posTagger
        String[] tags = posTagger.tag(tokens);

        // Chunk the sentence
        Span[] chunks = chunker.chunkAsSpans(tokens, tags);

        List<String> chunkList = new ArrayList<>();
        for (Span chunk : chunks) {
            chunkList.add(chunk.toString());
        }
        return chunkList;
    }
}
