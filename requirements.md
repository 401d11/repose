# Software Requirements

## Vision

- Example: EmployeMee is the premier recruiting website designed to streamline and modernize the hiring process for business looking for qualified employees. EmployMee stores a database of potential employees that hiring business can filter, review, and ultimately notify the other party for job offers. EmployMee is useful for both users that sign up for the website looking for job opportunities and businesses that are looking to offer specific opportunities for qualified individuals rather than sifting through a pile of resumes.
- Convinent andriod application
- Fight sedentary lifestyle
- Promote physical activity and wellness
- Mindfullness and focus
- Easte stress
- Designed to help people b ecome more active in their daily routine


## Scope

- Features:
  - A signup/login for users.
  - Allow users to select a routine of their liking.
  - Timer functionality that resets on end of stretches and restarts.
  - Changes streches after completes sets.
  - Visually appealing and theme.

### MVP

- Example: A website that allows businesses and individuals to sign up and login. Individuals will have a profile page to display their info. Businesses will be able to hit a button and add individuals to their "interested/contact" list. Presumably, the EmployMee company would then notify the individual about their prospective job opportunity, job info, interviews, etc.
- 

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
