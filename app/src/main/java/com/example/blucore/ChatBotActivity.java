package com.example.blucore;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import java.io.IOException;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ChatBotActivity extends AppCompatActivity {

    private static final int NUM_CLASSES =10;
    private EditText inputText;
    private TextView responseText;
    private ChatBot chatBot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        inputText = findViewById(R.id.inputText);
        Button sendButton = findViewById(R.id.sendButton);
        responseText = findViewById(R.id.responseText);

        try {
            // Initialize your ChatBot instance with your model path
            AssetManager assetManager = getAssets();
            chatBot = new ChatBot(assetManager, "model.tflite");
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Model loading failed", Toast.LENGTH_SHORT).show();
            return;
        }

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = inputText.getText().toString().trim();
                if (userInput.isEmpty()) {
                    Toast.makeText(ChatBotActivity.this, "Please enter a message", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Convert input to float array (example: you may need to preprocess the input)
                float[] input = preprocessInput(userInput);

                // Get prediction from the chatbot
                float[] prediction = chatBot.predict(input);

                // Process the prediction to form a response (example)
                String response = processResponse(prediction);

                // Display the response
                responseText.setText(response);
                inputText.setText(""); // Clear input field
            }
        });
    }

    private float[] preprocessInput(String input) {
        // Implement your preprocessing logic here
        // This is just an example, modify based on your model's requirements
        float[] inputArray = new float[NUM_CLASSES]; // Adjust based on input size
        // Populate inputArray based on your input
        return inputArray;
    }

    private String processResponse(float[] prediction) {
        // Implement your logic to convert prediction to a response string
        // Example: find the index of the highest prediction
        int maxIndex = 0;
        for (int i = 1; i < prediction.length; i++) {
            if (prediction[i] > prediction[maxIndex]) {
                maxIndex = i;
            }
        }
        return "Response for class " + maxIndex; // Replace with actual response logic
    }
}