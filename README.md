# Social Spark Android App

## 📱 Purpose of the App
**Social Spark** is a native Android application developed in Kotlin. It was designed to help users (specifically our friend Cora) maintain social connections during busy days. The app simplifies social interactions by providing quick, actionable "sparks" (suggestions) based on the time of day. It ensures that maintaining relationships is quick, easy, and fun.

## 🎨 Design Considerations
*   **User Interface:** The app uses a clean, minimalist `LinearLayout` designed for ease of use. Material Design components (like `TextInputLayout`) are used to provide a modern, engaging look that captivates the user.
*   **Logic:** The app utilizes Kotlin `when` statements to evaluate the user's text input. It converts the input to lowercase to ensure case-insensitive matching.
*   **Error Handling:** Robust error handling is implemented. If the user leaves the input blank or enters an unrecognized time, the app provides constructive feedback via `Toast` messages and on-screen text, motivating the user to correct their input.

## ⚙️ App Features
1.  **Text Input:** A text field for the user to type the time of day (e.g., "Morning", "Afternoon", "Dinner").
2.  **Display Suggestions:** Displays a specific social suggestion based on the time entered:
    *   **Morning:** Send a "Good morning" text to a family member.
    *   **Mid-morning:** Reach out to a colleague with a quick "Thank you."
    *   **Afternoon:** Share a funny meme or interesting link with a friend.
    *   **Afternoon Snack Time:** Send a quick "thinking of you" message.
    *   **Dinner:** Call a friend or relative for a 5-minute catch-up.
    *   **After Dinner / Night:** Leave a thoughtful comment on a friend's post.
3.  **Reset Button:** Clears the input field and the suggestion display.
4.  **Logging:** Extensive use of `Log.d` and `Log.e` to track user actions and errors for debugging.
