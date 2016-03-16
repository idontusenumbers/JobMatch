--
-- Seed the Role database with possible user roles
--
MERGE INTO ROLE AS t USING (VALUES(1,'Admin'), (2, 'Seeker'), (3, 'Employer')) AS vals(id,name)
ON t.ID=vals.id
WHEN MATCHED THEN UPDATE SET t.NAME=TRIM(vals.name)
WHEN NOT MATCHED THEN INSERT VALUES vals.id, TRIM(vals.name);

--
-- Seed the skill table with possible user skills
--
MERGE INTO SKILL AS t USING (VALUES
(1,'C++'), (2, 'Java'), (3, 'HTML'), (4, 'CSS'), (5, 'JavaScript'), (6, 'C#'), (7, 'PHP'), (8, 'SQL')
) AS vals(a,b)
ON t.ID=vals.a
WHEN MATCHED THEN UPDATE SET t.NAME=vals.b
WHEN NOT MATCHED THEN INSERT VALUES vals.a, vals.b;

--
-- Seed the culture table with possible user skills
--
MERGE INTO CULTURE AS t USING (VALUES(1,'Work from home'), (2, 'Casual dress'),(3, 'Creative') ,(4, 'Logical') ,(5, 'Problem Solver') ,(6, 'Good Listener') ,(7, 'Oral Communicator') ,(8, 'Written Communicator') ,(9, 'Flexibility in Scheduling') ,(10, 'People Skills') ,(11, 'Punctual') ,(12, 'Accurate') ,(13, 'Efficient') ,(14, 'Multi-Tasker') ,(15, 'Analytical') ,(16, 'Planner') ,(17, 'Researcher') ,(18, 'Team Leader') ,(19, 'Team Member') ,(20, 'Stamina') ,(21, 'Like Fast Pace') ,(22, 'Relationship Builder') ,(23, 'UX/UI') ,(24, 'Teacher/Mentor')) AS vals(a,b)
ON t.ID=vals.a
WHEN MATCHED THEN UPDATE SET t.NAME=vals.b
WHEN NOT MATCHED THEN INSERT VALUES vals.a, vals.b;


-- add username:password admin:admin
MERGE INTO USER USING (VALUES(1,1,'admin','$2a$10$YqRRWHt2cBc8iW/4MCl9bO2u6Bj.W2eZR5yiPUoggnWK1Wc6h9wpW')) AS vals(id,role_id, username, password)
ON USER.ID=vals.id
WHEN MATCHED THEN UPDATE SET role_id = vals.role_id, username=vals.username, password=vals.password
WHEN NOT MATCHED THEN INSERT (id, role_id, username, password) VALUES (vals.id, vals.role_id, vals.username, vals.password);