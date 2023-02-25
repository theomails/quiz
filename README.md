# Quiz - Build your own Picture quiz!

#### Here's the 3-step process to make your own amazing picture quiz!

 1. Build an interesting collection of pictures, organized into folders based on the categories.
 2. Drop `quiz.jar` into the same folder
 3. Double-click on quiz.jar to launch the app and play!!
 
Here's an example. There is a collection of pictures organized into folders in the background. `Qiuz` brings it to life as a live picture quiz right on your desktop! 

<img width="1627" alt="Screenshot 2023-02-25 at 12 50 22 PM" src="https://user-images.githubusercontent.com/8006169/221344728-b68594c1-5d00-4794-b54d-64309d3cbca0.png">

Gather around your desk or screen-share on your favourite online meeting app to play with your friends!
 
### Happy Quizzing!

#### The finer details:

 1. The folders which are siblings to `quiz.jar` are considered as _Categories_. They are presented as `tabs` in the Quiz app.
 2. The files inside those folders are considered as _Quiz images_. They are presented as `images` in the Quiz app.
 3. The user can select any _Category_ tab. There is only forward navigation to go to the next _Quiz image_.
 4. Each time when the `Show` button is clicked, the image is shown for a few seconds and then hidden automatically.
 5. You can choose to click the `Show` button more times to reveal the image repeatedly.
 6. Once the player has finished guessing or given up, click on `Show Answer` to reveal the answer.
 7. Note that the _Quiz image_ file name (upto the first `.` symbol in the file name) is considered as the answer for each _Quiz image_.
 8. The user (host) can click on the appropriate `+10` or `+5` button for the current team based on whether they answered during their turn, or a passed question.
 9. Run through several rounds of the game for some exciting picture quiz fun!
 10. At the end of the game, the scores are visible for everyon to see. 
 11. May the best team win!!

#### Building and Running the project

 1. Click on `Maven Update Project` to ensure that project `pom.xml` settings are in sync with your IDE settings.
 2. Run `Maven Install` to build the jar files in `/target` folder and them install the jars into the local maven repo.
 3. Copy the `quiz-<version>-jar-with-dependencies.jar' file from the `/target` folder to a QUIZ folder. Rename this file as `quiz.jar` for convenience.
 4. Drop all the categorized pictures as folders right next to `quiz.jar`.
 5. Double click on `quiz.jar` to start the app.
 
