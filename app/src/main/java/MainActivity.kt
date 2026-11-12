package com.example.socialsparkapp // Make sure this matches your package name

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // 1. Define UI variables
    private lateinit var etTimeOfDay: EditText
    private lateinit var btnGetSpark: Button
    private lateinit var btnReset: Button
    private lateinit var tvSuggestion: TextView

    private val TAG = "SocialSparkApp" // Tag for logging

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2. Link UI variables to the XML layout
        etTimeOfDay = findViewById(R.id.etTimeOfDay)
        btnGetSpark = findViewById(R.id.btnGetSpark)
        btnReset = findViewById(R.id.btnReset)
        tvSuggestion = findViewById(R.id.tvSuggestion)

        // 3. Set up the "Get Spark" Button Click Listener
        btnGetSpark.setOnClickListener {
            val timeInput = etTimeOfDay.text.toString().trim()
            Log.d(TAG, "User entered: $timeInput") // Logging requirement

            if (timeInput.isEmpty()) {
                // Error Handling: Empty input
                Log.e(TAG, "Input was empty")
                Toast.makeText(this, "Please enter a time of day first!", Toast.LENGTH_SHORT).show()
            } else {
                // Process the input
                getSuggestionForTime(timeInput)
            }
        }

        // 4. Set up the "Reset" Button Click Listener
        btnReset.setOnClickListener {
            Log.d(TAG, "Reset button clicked")
            etTimeOfDay.text.clear() // Clears the input field
            tvSuggestion.text = "Your suggestion will appear here." // Resets the text
        }
    }

    // Function to determine the suggestion based on the user's input
    private fun getSuggestionForTime(time: String) {
        // We use lowercase to make the matching case-insensitive
        val suggestion = when (time.lowercase()) {
            "morning", "early morning" -> "Send a \"Good morning\" text to a family member."
            "mid-morning", "mid morning" -> "Reach out to a colleague with a quick \"Thank you.\""
            "afternoon", "midday", "lunch" -> "Share a funny meme or interesting link with a friend."
            "afternoon snack time", "snack time" -> "Send a quick \"thinking of you\" message."
            "dinner", "evening", "supper" -> "Call a friend or relative for a 5-minute catch-up."
            "after dinner", "night", "late night" -> "Leave a thoughtful comment on a friend's post."
            else -> null // Default case if no match is found
        }

        if (suggestion != null) {
            // Success: Display the suggestion
            Log.d(TAG, "Successfully found suggestion for $time")
            tvSuggestion.text = suggestion
        } else {
            // Error Handling: Invalid/Unrecognized input
            Log.w(TAG, "Unrecognized time input: $time")
            tvSuggestion.text = "No suggestion found."
            Toast.makeText(
                this,
                "Invalid time. Try: Morning, Afternoon, Dinner, or Night.",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
