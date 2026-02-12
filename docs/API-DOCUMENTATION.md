# API Documentation

Base URL: /api

## Auth APIs
POST   /auth/register
POST   /auth/login
GET    /auth/profile

## Course APIs
GET    /courses
GET    /courses/{id}
POST   /courses
PUT    /courses/{id}
DELETE /courses/{id}

## Topic APIs
GET    /topics/{courseId}
POST   /topics

## Problem APIs
GET    /problems
GET    /problems/{id}

## Compiler API
POST   /compiler/run
