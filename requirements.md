# Software Requirements

## Vision

- The most convenient stretching mobile application with a personalized experience to provide users physical healing and mental focus to improve quality of life. rePose's purpose is to improve flexibility and decrease stress on muscle and joints. Our vision is to have rePose downloaded on every modern employed and unemployed person's phone for use during 10-minute breaks, lunch hours, and spare time at home.

Our Strategy: 
- Convenient Android application
- Fight sedentary lifestyle
- Promote physical activity and wellness
- Mindfulness and focus
- Ease stress
- Designed to help people become more active in their daily routine

## Scope

- Features:
  - A signup/login for users.
  - Allow users to select a routine of their liking.
  - Timer functionality that resets on end of stretches and restarts.
  - Changes stretch after completing sets.
  - Visually appealing and theme.

### MVP

- Mobile application that allows all users access to stretches pre-defined and grouped by muscle group.
- Provide users imagery and directions on how to properly perform the stretches.
- Allow users to select a specific stretch based on their needs.
- Allow users option to start/stop/pause an exercise.

### Stretch Goals

- Add their own custom stretches to their personal library
- Have the ability to pause and resume their workout.
- Text to speech
- Drag and drop to configure order
- Audio

## Functional Requirements

- Sign up for users.
- Login page.
- Home page that greets the user that has logged in.
- Routine pages that has radio buttons that will display the stretches  in a recyclerView.
- Stretch page that displays the current stretch's information: name, image, description, sets, and reps.
- Finished page that allows the user to restart the same routine or go to the home page.

## Non-Functional Requirements

- Site is secured using AWS Cognito.
- Data is stored us AWS DynamoDB.
- Data modeling schema built with GraphQL
- Images are uploaded and retrieved from AWS S3
- Test using Espresso
