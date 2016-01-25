--
-- Seed the Role database with possible user roles
--
MERGE INTO ROLE AS t USING (VALUES(1,'user'), (2, 'company')) AS vals(a,b)
        ON t.ID=vals.a
    WHEN MATCHED THEN UPDATE SET t.ROLE_NAME=vals.b
    WHEN NOT MATCHED THEN INSERT VALUES vals.a, vals.b;

--
-- Seed the skill table with possible user skills
--
MERGE INTO SKILL AS t USING (VALUES(1,'C++'), (2, 'Java')) AS vals(a,b)
ON t.ID=vals.a
WHEN MATCHED THEN UPDATE SET t.NAME=vals.b
WHEN NOT MATCHED THEN INSERT VALUES vals.a, vals.b;