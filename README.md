# Code_Pulse

# CodePulse

CodePulse is a full-stack developer profile aggregation platform that collects coding statistics from multiple platforms and presents them through a unified dashboard.

## Features

* Developer profile dashboard
* Unified leaderboard system
* LeetCode integration
* Codeforces integration
* GitHub integration
* GitHub activity heatmap
* Platform-wise statistics comparison
* Leaderboard ranking system
* Profile refresh functionality
* Responsive modern UI

## Tech Stack

### Frontend

* React
* TypeScript
* Vite
* Tailwind CSS
* Axios
* Recharts

### Backend

* Spring Boot
* Spring Data JPA
* Hibernate
* Maven

### Database

* MySQL

### Deployment

* Frontend: Render
* Backend: Render
* Database: Railway (currently unavailable due to expired trial)

---

## Project Architecture

Frontend (React + TypeScript)

↓

Backend REST APIs (Spring Boot)

↓

MySQL Database

↓

External Platform APIs

* LeetCode
* Codeforces
* GitHub

---

## Current Implemented Modules

### User Management

* Create User
* Get User Details
* Profile Dashboard

### Platform Accounts

* Link GitHub Account
* Link LeetCode Account
* Link Codeforces Account

### Statistics Tracking

* Current Rating
* Highest Rating
* Problems Solved
* Leaderboard Score

### Dashboard

* Profile Overview
* Platform Cards
* Statistics Visualization
* GitHub Activity Heatmap

### Leaderboard

* Global Ranking
* Score Based Ordering

---

## API Endpoints

### User APIs

GET /api/users/{id}

POST /api/users

GET /api/users

### Platform Account APIs

POST /api/platform-accounts

GET /api/platform-accounts/user/{userId}

### Profile APIs

GET /api/profile/{userId}

POST /api/profile/refresh/{userId}

### Leaderboard APIs

GET /api/leaderboard

---

## Current Deployment Status

### Successfully Deployed

Frontend:
https://code-pulse-frontend-u930.onrender.com

Backend:
https://code-pulse-s70j.onrender.com

### Current Issue

The Railway MySQL trial has expired.

Because of this:

* Database operations are unavailable
* Refresh Stats functionality is currently failing
* New updates cannot be persisted

Planned Fix:

* Migrate database to Render PostgreSQL / Railway Paid Plan / Neon Database

---

## Upcoming Features

### Google OAuth Authentication

Planned implementation:

* Login with Google
* User registration through Google account
* Session management
* Removal of hardcoded user IDs
* Personalized dashboards

### Future Enhancements

* Contest tracking
* Coding streaks
* Skill analytics
* Achievement badges
* Friend comparison system
* Daily progress reports
* Multi-user support

---

## Author

Hema Naga Chand

B.Tech CSE

KL University

---

## Project Status

Current Version: MVP (Minimum Viable Product)

The core dashboard, leaderboard, profile aggregation, and deployment have been completed. The next major milestone is implementing Google OAuth authentication and migrating the database to a permanent cloud database solution.
