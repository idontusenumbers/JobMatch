--
-- Seed the Role database with possible user roles
--
MERGE INTO ROLE AS t USING (VALUES(1,TRIM('Admin')), (2, TRIM('Seeker')), (3, TRIM('Employer'))) AS vals(id,name)
ON t.ID=vals.id
WHEN MATCHED THEN UPDATE SET t.NAME=vals.name
WHEN NOT MATCHED THEN INSERT VALUES vals.id, vals.name;

--
-- Seed the skill table with possible user skills
--
MERGE INTO SKILL AS t USING (VALUES(1,TRIM('C++')), (2, TRIM('Java'))) AS vals(a,b)
ON t.ID=vals.a
WHEN MATCHED THEN UPDATE SET t.NAME=vals.b
WHEN NOT MATCHED THEN INSERT VALUES vals.a, vals.b;


-- add username:password admin:admin
MERGE INTO USER USING (VALUES(1,1,'admin','$2a$10$YqRRWHt2cBc8iW/4MCl9bO2u6Bj.W2eZR5yiPUoggnWK1Wc6h9wpW')) AS vals(id,role_id, username, password)
ON USER.ID=vals.id
WHEN MATCHED THEN UPDATE SET role_id = vals.role_id, username=vals.username, password=vals.password
WHEN NOT MATCHED THEN INSERT (id, role_id, username, password) VALUES (vals.id, vals.role_id, vals.username, vals.password);