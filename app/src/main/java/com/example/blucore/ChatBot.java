package com.example.blucore;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import org.tensorflow.lite.Interpreter;
import java.io.FileInputStream;
import java.io.IOException;  // Add this import
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ChatBot {
    private Interpreter interpreter;
    private static final int NUM_CLASSES = 10; // Adjust as needed

    public ChatBot(AssetManager assetManager, String modelPath) throws IOException {
        interpreter = new Interpreter(loadModelFile(assetManager, modelPath));
    }

    private MappedByteBuffer loadModelFile(AssetManager assetManager, String modelPath) throws IOException {
        AssetFileDescriptor fileDescriptor = assetManager.openFd(modelPath);
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    public float[] predict(float[] input) {
        float[][] output = new float[1][NUM_CLASSES];
        interpreter.run(input, output);
        return output[0];
    }

    public void close() {
        if (interpreter != null) {
            interpreter.close();
        }
    }
}