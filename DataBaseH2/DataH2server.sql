DROP TABLE "Type";
DROP TABLE "Tournament";
DROP TABLE "Team";
DROP TABLE "Member";
DROP TABLE "Entry";

INSERT INTO "Type" ("Type", "Fee") VALUES ('Junior', 150);
INSERT INTO "Type" ("Type", "Fee") VALUES ('Senior', 300);
INSERT INTO "Type" ("Type", "Fee") VALUES ('Social', 50);

-- Inserting into "Tournament" table
INSERT INTO "Tournament" ("TourName", "TourType") VALUES ('Leeston', 'Social');
INSERT INTO "Tournament" ("TourName", "TourType") VALUES ('Kaiapoi', 'Social');
INSERT INTO "Tournament" ("TourName", "TourType") VALUES ('WestCoast', 'Open');
INSERT INTO "Tournament" ("TourName", "TourType") VALUES ('Canterbury', 'Open');
INSERT INTO "Tournament" ("TourName", "TourType") VALUES ('Otago', 'Open');


-- Inserting into "Team" table
INSERT INTO "Team" ("Manager", "TeamName", "PracticeNight") VALUES (239, 'TeamA', 'Tuesday');
INSERT INTO "Team" ("Manager", "TeamName", "PracticeNight") VALUES (153, 'TeamB', 'Monday');



-- Inserting into "Member" table
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (118, 'McKenzie', 'Melissa', 'Junior', '963270', 30, '2005-05-28', NULL, NULL, 'F');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (138, 'Stone', 'Michael', 'Senior', '983223', 30, '2009-05-31', NULL, NULL, 'M');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (153, 'Nolan', 'Brenda', 'Senior', '442649', 11, '2006-08-12', NULL, 'TeamB', 'F');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (176, 'Branch', 'Helen', 'Social', '589419', NULL, '2011-12-06', NULL, NULL, 'F');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (178, 'Beck', 'Sarah', 'Social', '226596', NULL, '2010-01-24', NULL, NULL, 'F');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (228, 'Burton', 'Sandra', 'Junior', '244493', 26, '2013-07-09', NULL, NULL, 'F');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (235, 'Cooper', 'William', 'Senior', '722954', 14, '2008-03-05', NULL, 'TeamB', 'M');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (239, 'Spence', 'Thomas', 'Senior', '697720', 10, '2006-06-22', NULL, NULL, 'M');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (258, 'Olson', 'Barbara', 'Senior', '370186', 16, '2013-07-29', NULL, NULL, 'F');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (286, 'Pollard', 'Robert', 'Junior', '617681', 19, '2013-08-13', NULL, 'TeamB', 'M');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (290, 'Sexton', 'Thomas', 'Senior', '268936', 26, '2008-07-28', NULL, NULL, 'M');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (323, 'Wilcox', 'Daniel', 'Senior', '665393', 3, '2009-05-18', NULL, 'TeamA', 'M');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (331, 'Schmidt', 'Thomas', 'Senior', '867492', 25, '2009-04-07', NULL, NULL, 'M');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (332, 'Bridges', 'Deborah', 'Senior', '279087', 12, '2007-03-23', NULL, NULL, 'F');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (339, 'Young', 'Betty', 'Senior', '507813', 21, '2009-04-17', NULL, 'TeamB', 'F');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (414, 'Gilmore', 'Jane', 'Junior', '459558', 5, '2007-05-30', NULL, 'TeamA', 'F');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (415, 'Taylor', 'William', 'Senior', '137353', 7, '2007-11-27', NULL, 'TeamA', 'M');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (461, 'Reed', 'Robert', 'Senior', '994664', 3, '2005-08-05', NULL, 'TeamA', 'M');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (469, 'Willis', 'Carolyn', 'Junior', '688378', 29, '2011-01-14', NULL, NULL, 'F');
INSERT INTO "Member" ("MemberID", "LastName", "FirstName", "MemberType", "Phone", "Handicap", "JoinDate", "Coach", "Team", "Gender") VALUES (487, 'Kent', 'Susan', 'Social', '707217', NULL, '2010-10-07', NULL, NULL, 'F');

-- Inserting into "Entry" table
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (118, 1, 2014);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (228, 1, 2015);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (228, 2, 2015);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (228, 3, 2015);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (235, 4, 2013);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (235, 4, 2015);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (235, 5, 2014);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (235, 5, 2015);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (239, 2, 2015);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (239, 5, 2013);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (258, 1, 2014);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (258, 4, 2014);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (286, 1, 2013);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (286, 1, 2014);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (286, 1, 2015);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (415, 1, 2015);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (415, 2, 2013);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (415, 3, 2014);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (415, 3, 2015);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (415, 4, 2013);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (415, 4, 2015);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (415, 5, 2013);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (415, 5, 2014);
INSERT INTO "Entry" ("MemberID", "TourID", "EYear") VALUES (415, 5, 2015);



-- Updating "Team" table
UPDATE "Team" SET "Manager" = 239 WHERE "TeamName" = 'TeamA';
UPDATE "Team" SET "Manager" = 153 WHERE "TeamName" = 'TeamB';

-- Updating "Member" table
UPDATE "Member" SET "Coach" = 153 WHERE "MemberID" = 118;
UPDATE "Member" SET "Coach" = 153 WHERE "MemberID" = 228;
UPDATE "Member" SET "Coach" = 153 WHERE "MemberID" = 235;
UPDATE "Member" SET "Coach" = 235 WHERE "MemberID" = 286;
UPDATE "Member" SET "Coach" = 235 WHERE "MemberID" = 290;
UPDATE "Member" SET "Coach" = 153 WHERE "MemberID" = 331;
UPDATE "Member" SET "Coach" = 235 WHERE "MemberID" = 332;
UPDATE "Member" SET "Coach" = 153 WHERE "MemberID" = 414;
UPDATE "Member" SET "Coach" = 235 WHERE "MemberID" = 415;
UPDATE "Member" SET "Coach" = 235 WHERE "MemberID" = 461;
