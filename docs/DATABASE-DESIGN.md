# Database Design

## users
- id
- name
- email
- password
- role
- created_at

## courses
- id
- title
- description
- category

## topics
- id
- course_id
- title
- content

## problems
- id
- topic_id
- title
- description
- difficulty

## submissions
- id
- user_id
- problem_id
- code
- language
- result
