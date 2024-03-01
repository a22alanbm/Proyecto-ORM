-- Insert statements
INSERT INTO Type VALUES ('Junior', 150);
INSERT INTO Type VALUES ('Senior', 300);
INSERT INTO Type VALUES ('Social', 50);

INSERT INTO Tournament VALUES (24, 'Leeston', 'Social');
INSERT INTO Tournament VALUES (25, 'Kaiapoi', 'Social');
INSERT INTO Tournament VALUES (36, 'WestCoast', 'Open');
INSERT INTO Tournament VALUES (38, 'Canterbury', 'Open');
INSERT INTO Tournament VALUES (40, 'Otago', 'Open');

INSERT INTO Team VALUES ('TeamA', 'Tuesday', NULL);
INSERT INTO Team VALUES ('TeamB', 'Monday', NULL);

INSERT INTO Member VALUES (118, 'McKenzie', 'Melissa', 'Junior', '963270', 30, '2005-05-28', NULL, NULL, 'F');
INSERT INTO Member VALUES (138, 'Stone', 'Michael', 'Senior', '983223', 30, '2009-05-31', NULL, NULL, 'M');
INSERT INTO Member VALUES (153, 'Nolan', 'Brenda', 'Senior', '442649', 11, '2006-08-12', NULL, 'TeamB', 'F');
INSERT INTO Member VALUES (176, 'Branch', 'Helen', 'Social', '589419', NULL, '2011-12-06', NULL, NULL, 'F');
INSERT INTO Member VALUES (178, 'Beck ', 'Sarah', 'Social', '226596', NULL, '2010-01-24', NULL, NULL, 'F');
INSERT INTO Member VALUES (228, 'Burton', 'Sandra', 'Junior', '244493', 26, '2013-07-09', NULL, NULL, 'F');
INSERT INTO Member VALUES (235, 'Cooper', 'William', 'Senior', '722954', 14, '2008-03-05', NULL, 'TeamB', 'M');
INSERT INTO Member VALUES (239, 'Spence', 'Thomas', 'Senior', '697720', 10, '2006-06-22', NULL, NULL, 'M');
INSERT INTO Member VALUES (258, 'Olson', 'Barbara', 'Senior', '370186', 16, '2013-07-29', NULL, NULL, 'F');
INSERT INTO Member VALUES (286, 'Pollard', 'Robert', 'Junior', '617681', 19, '2013-08-13', NULL, 'TeamB', 'M');
INSERT INTO Member VALUES (290, 'Sexton ', 'Thomas', 'Senior', '268936', 26, '2008-07-28', NULL, NULL, 'M');
INSERT INTO Member VALUES (323, 'Wilcox', 'Daniel', 'Senior', '665393', 3, '2009-05-18', NULL, 'TeamA', 'M');
INSERT INTO Member VALUES (331, 'Schmidt', 'Thomas', 'Senior', '867492', 25, '2009-04-07', NULL, NULL, 'M');
INSERT INTO Member VALUES (332, 'Bridges', 'Deborah', 'Senior', '279087', 12, '2007-03-23', NULL, NULL, 'F');
INSERT INTO Member VALUES (339, 'Young', 'Betty', 'Senior', '507813', 21, '2009-04-17', NULL, 'TeamB', 'F');
INSERT INTO Member VALUES (414, 'Gilmore', 'Jane ', 'Junior', '459558', 5, '2007-05-30', NULL, 'TeamA', 'F');
INSERT INTO Member VALUES (415, 'Taylor', 'William', 'Senior', '137353', 7, '2007-11-27', NULL, 'TeamA', 'M');
INSERT INTO Member VALUES (461, 'Reed ', 'Robert', 'Senior', '994664', 3, '2005-08-05', NULL, 'TeamA', 'M');
INSERT INTO Member VALUES (469, 'Willis', 'Carolyn', 'Junior', '688378', 29, '2011-01-14', NULL, NULL, 'F');
INSERT INTO Member VALUES (487, 'Kent ', 'Susan', 'Social', '707217', NULL, '2010-10-07', NULL, NULL, 'F');

INSERT INTO Entry VALUES (118, 24, 2014);
INSERT INTO Entry VALUES (228, 24, 2015);
INSERT INTO Entry VALUES (228, 25, 2015);
INSERT INTO Entry VALUES (228, 36, 2015);
INSERT INTO Entry VALUES (235, 38, 2013);
INSERT INTO Entry VALUES (235, 38, 2015);
INSERT INTO Entry VALUES (235, 40, 2014);
INSERT INTO Entry VALUES (235, 40, 2015);
INSERT INTO Entry VALUES (239, 25, 2015);
INSERT INTO Entry VALUES (239, 40, 2013);
INSERT INTO Entry VALUES (258, 24, 2014);
INSERT INTO Entry VALUES (258, 38, 2014);
INSERT INTO Entry VALUES (286, 24, 2013);
INSERT INTO Entry VALUES (286, 24, 2014);
INSERT INTO Entry VALUES (286, 24, 2015);
INSERT INTO Entry VALUES (415, 24, 2015);
INSERT INTO Entry VALUES (415, 25, 2013);
INSERT INTO Entry VALUES (415, 36, 2014);
INSERT INTO Entry VALUES (415, 36, 2015);
INSERT INTO Entry VALUES (415, 38, 2013);
INSERT INTO Entry VALUES (415, 38, 2015);
INSERT INTO Entry VALUES (415, 40, 2013);
INSERT INTO Entry VALUES (415, 40, 2014);
INSERT INTO Entry VALUES (415, 40, 2015);

-- Update statements
UPDATE Team SET Manager = 239 WHERE TeamName ='TeamA';
UPDATE Team SET Manager = 153 WHERE TeamName ='TeamB';

UPDATE Member SET Coach = 153 WHERE MemberID = 118;
UPDATE Member SET Coach = 153 WHERE MemberID = 228;
UPDATE Member SET Coach = 153 WHERE MemberID = 235;
UPDATE Member SET Coach = 235 WHERE MemberID = 286;
UPDATE Member SET Coach = 235 WHERE MemberID = 290;
UPDATE Member SET Coach = 153 WHERE MemberID = 331;
UPDATE Member SET Coach = 235 WHERE MemberID = 332;
UPDATE Member SET Coach = 153 WHERE MemberID = 414;
UPDATE Member SET Coach = 235 WHERE MemberID = 415;
UPDATE Member SET Coach = 235 WHERE MemberID = 461;
