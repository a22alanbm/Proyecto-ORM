-- Drop tables if they exist
DROP TABLE IF EXISTS Type;
DROP TABLE IF EXISTS Member;
DROP TABLE IF EXISTS Tournament;
DROP TABLE IF EXISTS Entry;
DROP TABLE IF EXISTS Team;

-- Type Table
CREATE TABLE IF NOT EXISTS Type (
    Type TEXT PRIMARY KEY,
    Fee INTEGER
);

-- Member Table
CREATE TABLE IF NOT EXISTS Member (
    MemberID INTEGER PRIMARY KEY,
    LastName TEXT,
    FirstName TEXT,
    MemberType TEXT REFERENCES Type(Type),
    Phone TEXT,
    Handicap INTEGER,
    JoinDate DATE,
    Coach INTEGER REFERENCES Member(MemberID),
    Team TEXT REFERENCES Team(TeamName),
    Gender TEXT,
    CONSTRAINT FK_Coach FOREIGN KEY (Coach) REFERENCES Member(MemberID),
    CONSTRAINT FK_Team FOREIGN KEY (Team) REFERENCES Team(TeamName)
);

-- Tournament Table
CREATE TABLE IF NOT EXISTS Tournament (
    TourID INTEGER PRIMARY KEY,
    TourName TEXT,
    TourType TEXT
);

-- Entry Table
CREATE TABLE IF NOT EXISTS Entry (
    MemberID INTEGER REFERENCES Member(MemberID),
    TourID INTEGER REFERENCES Tournament(TourID),
    Year INTEGER,
    PRIMARY KEY (MemberID, TourID, Year)
);

-- Team Table
CREATE TABLE IF NOT EXISTS Team (
    TeamName TEXT PRIMARY KEY,
    PracticeNight TEXT,
    Manager INTEGER REFERENCES Member(MemberID)
);
