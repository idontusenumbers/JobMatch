--
-- Seed the Role database with possible user roles
--
MERGE INTO ROLE AS t USING (VALUES(1,TRIM('admin')), (2, TRIM('student')), (3, TRIM('employer'))) AS vals(id,name)
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



