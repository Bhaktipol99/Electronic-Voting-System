Electronic Voting System (Spring Boot + MySQL)

A secure and efficient online voting platform built with Spring Boot and MySQL. The system enables secure user registration, election creation, real-time vote tallying, and role-based access control for both voters and administrators. Features include:
User Registration and Authentication:

Voter Registration: Voters can register with a unique username/email and a secure password. Data validation ensures accurate information.
JWT Authentication: Voters and administrators authenticate via JSON Web Tokens (JWT) for secure and stateless sessions.
Role-Based Access Control: Users are assigned roles like Voter or Admin, allowing different levels of access to system features.
Election Management (Admin):

Create Elections: Admins can create new elections with specific details such as election name, start/end date, and candidates.
Manage Candidates: Admins can add, edit, or remove candidates for each election.
View Election Status: Admins can view ongoing and completed elections, track voter participation, and manage election details.
Voting System (Voter):

View Elections: Voters can view the list of available elections with candidate details.
Cast Vote: Voters can select a candidate in an election and cast their vote securely.
Vote Confirmation: After voting, voters receive a confirmation message and cannot change their vote.
Prevent Duplicate Voting: The system ensures that each voter can only vote once per election using unique voter IDs.
Real-Time Vote Tallying:

Instant Vote Count: Votes are counted in real-time, and election results are updated instantly on the admin dashboard.
Detailed Results: Admins can view the detailed breakdown of votes cast for each candidate in every election.
Security Features:

Data Encryption: Sensitive data, including passwords, is encrypted using industry-standard encryption algorithms (e.g., bcrypt).
Spring Security: Provides role-based authentication and authorization, ensuring that only authorized users can access certain endpoints.
Tamper Prevention: Strict validation mechanisms prevent any unauthorized manipulation of votes or election data.
