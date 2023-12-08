CREATE TABLE IF NOT EXISTS AdvisorSpecialty (
    MajorID VARCHAR(200),
    AdvisorID VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS Faculty (
    FacultyID VARCHAR(200) NOT NULL UNIQUE,
    FName VARCHAR(200),
    LName VARCHAR(200),
    Password VARCHAR(200) UNIQUE,
    PRIMARY KEY(FacultyID)
) ENGINE=InnoDB;

INSERT INTO Faculty VALUES('2','Greg','Glickley','12345678');
INSERT INTO Faculty VALUES('1111','Albert','Einstein','11111111');
INSERT INTO Faculty VALUES('2222','Isaac','Newton','22222222');
INSERT INTO Faculty VALUES('3333','Alan','Turing','33333333');
INSERT INTO Faculty VALUES('4444','Ada','Lovelace','44444444');
INSERT INTO Faculty VALUES('5555','Adam','Smith','55555555');
INSERT INTO Faculty VALUES('6666','Benjamin','Graham','66666666');
INSERT INTO Faculty VALUES('7777','Abraham','Lincoln','77777777');
INSERT INTO Faculty VALUES('8888','Julius','Caesar','88888888');
INSERT INTO Faculty VALUES('9999','Pablo','Picasso','99999999');
INSERT INTO Faculty VALUES('0000','Vincent','Van Gogh','00000000');

CREATE TABLE IF NOT EXISTS Students (
    StudentID VARCHAR(200) NOT NULL UNIQUE,
    FName VARCHAR(200),
    LName VARCHAR(200),
    DOB VARCHAR(200),
    Password VARCHAR(200) UNIQUE,
    PRIMARY KEY(StudentID)
) ENGINE=InnoDB;

INSERT INTO Students VALUES('22222','Math','LoverB','1/1/01','222222222');
INSERT INTO Students VALUES('33333','Cmpsc','LoverA','1/1/01','333333333');
INSERT INTO Students VALUES('44444','Cmpsc','LoverB','1/1/01','444444444');
INSERT INTO Students VALUES('55555','Econ','LoverA','1/1/01','555555555');
INSERT INTO Students VALUES('66666','Econ','LoverB','1/1/01','666666666');
INSERT INTO Students VALUES('77777','Hist','LoverA','1/1/01','777777777');
INSERT INTO Students VALUES('88888','Hist','LoverB','1/1/01','888888888');
INSERT INTO Students VALUES('99999','Design','LoverA','1/1/01','999999999');
INSERT INTO Students VALUES('00000','Design','LoverB','1/1/01','000000000');
INSERT INTO Students VALUES('11111','Math','LoverA','1/1/01','111111111');
INSERT INTO Students VALUES('12345','Test','A','01/01/2001','123456789');

CREATE TABLE IF NOT EXISTS Departments (
    DeptID VARCHAR(200),
    DeptName VARCHAR(200),
    PRIMARY KEY(DeptID)
) ENGINE=InnoDB;

INSERT INTO Departments VALUES('SCI','Science');
INSERT INTO Departments VALUES('BSN','Business');
INSERT INTO Departments VALUES('HUM','Humanities');

CREATE TABLE IF NOT EXISTS Majors (
    MajorID VARCHAR(200) NOT NULL UNIQUE,
    MajorName VARCHAR(200),
    minGPA NUMERIC,
    Department VARCHAR(200),
    PRIMARY KEY(MajorID)
) ENGINE=InnoDB;


INSERT INTO Majors VALUES('MATH','Math',2,'Science');
INSERT INTO Majors VALUES('CMPSC','Computer Science',3,'Science');
INSERT INTO Majors VALUES('ECON','Economics',3,'Business');
INSERT INTO Majors VALUES('HIST','History',2,'Humanities');
INSERT INTO Majors VALUES('DSGN','Design',2,'Humanities');

CREATE TABLE IF NOT EXISTS Professors (
    ProfessorID VARCHAR(200) UNIQUE,
    MajorID VARCHAR(200),
    PRIMARY KEY(ProfessorID,MajorID),
    FOREIGN KEY(ProfessorID) REFERENCES Faculty(FacultyID) ON DELETE CASCADE,
    FOREIGN KEY(MajorID) REFERENCES Majors(MajorID) ON DELETE CASCADE
) ENGINE=InnoDB;

INSERT INTO Professors VALUES('1111','MATH');
INSERT INTO Professors VALUES('2222','MATH');
INSERT INTO Professors VALUES('3333','CMPSC');
INSERT INTO Professors VALUES('4444','CMPSC');
INSERT INTO Professors VALUES('5555','ECON');
INSERT INTO Professors VALUES('6666','ECON');
INSERT INTO Professors VALUES('7777','HIST');
INSERT INTO Professors VALUES('8888','HIST');
INSERT INTO Professors VALUES('9999','DSGN');
INSERT INTO Professors VALUES('0000','DSGN');


CREATE TABLE IF NOT EXISTS Classes (
    ClassID VARCHAR(200),
    ClassName VARCHAR(200),
    Subject VARCHAR(200),
    ClassNum INTEGER,
    Credits INTEGER,
    Department VARCHAR(200),
    PRIMARY KEY(ClassID),
    FOREIGN KEY(Department) REFERENCES Departments(DeptName)
) ENGINE=InnoDB;
INSERT INTO Classes VALUES('Math101','Intro Math','Math',101,3,'Science');
INSERT INTO Classes VALUES('Math201','Engineering Math','Math',201,3,'Science');
INSERT INTO Classes VALUES('Math202','Advanced Math','Math',202,3,'Science');
INSERT INTO Classes VALUES('Math203','Economic Math','Math',203,3,'Science');
INSERT INTO Classes VALUES('Math301','Complex Analysis','Math',301,3,'Science');
INSERT INTO Classes VALUES('Cmpsc101','Intro to Programming','Computer Science',101,3,'Science');
INSERT INTO Classes VALUES('Cmpsc201','Object Oriented Programming','Computer Science',201,3,'Science');
INSERT INTO Classes VALUES('Cmpsc202','Programming for Economists','Computer Science',202,3,'Science');
INSERT INTO Classes VALUES('Cmpsc203','Operating Systems','Computer Science',203,3,'Science');
INSERT INTO Classes VALUES('Cmpsc301','Database Management Systems','Computer Science',301,3,'Science');
INSERT INTO Classes VALUES('Econ101','Microeconomics','Economics',101,3,'Business');
INSERT INTO Classes VALUES('Econ102','Macroeconomics','Economics',102,3,'Business');
INSERT INTO Classes VALUES('Econ201','Trading Algorithms','Economics',201,3,'Business');
INSERT INTO Classes VALUES('Econ202','Advanced Economics','Economics',202,3,'Business');
INSERT INTO Classes VALUES('Econ301','Foreign Trade Economics','Economics',301,3,'Business');
INSERT INTO Classes VALUES('Hist101','Intro to American History','History',101,3,'Humanities');
INSERT INTO Classes VALUES('Hist102','Intro to World History','History',102,3,'Humanities');
INSERT INTO Classes VALUES('Hist201','Intermediate American History','History',201,3,'Humanities');
INSERT INTO Classes VALUES('Hist202','European History','History',202,3,'Humanities');
INSERT INTO Classes VALUES('Hist301','History of Conflicts','History',301,3,'Humanities');
INSERT INTO Classes VALUES('Desing101','Intro to Drawing','Design',101,3,'Humanities');
INSERT INTO Classes VALUES('Design201','Application of Color Theory','Design',201,3,'Humanities');
INSERT INTO Classes VALUES('Design202','Intro to UI/UX','Design',202,3,'Humanities');
INSERT INTO Classes VALUES('Design301','Architecture Design','Design',301,3,'Humanities');
INSERT INTO Classes VALUES('Design203','Painting at Scale','Design',203,3,'Humanities');

CREATE TABLE IF NOT EXISTS Teaches (
    ProfessorID VARCHAR(200),
    ClassID VARCHAR(200),
    FOREIGN KEY(ProfessorID) REFERENCES Professors(ProfessorID) ON DELETE CASCADE,
    FOREIGN KEY(ClassID) REFERENCES Classes(ClassID) ON DELETE CASCADE,
    PRIMARY KEY(ClassID,ProfessorID)
) ENGINE=InnoDB;

INSERT INTO Teaches VALUES('1111','Math101');
INSERT INTO Teaches VALUES('1111','Math202');
INSERT INTO Teaches VALUES('2222','Math201');
INSERT INTO Teaches VALUES('2222','Math203');
INSERT INTO Teaches VALUES('2222','Math301');
INSERT INTO Teaches VALUES('3333','Cmpsc101');
INSERT INTO Teaches VALUES('3333','Cmpsc201');
INSERT INTO Teaches VALUES('4444','Cmpsc202');
INSERT INTO Teaches VALUES('4444','Cmpsc203');
INSERT INTO Teaches VALUES('4444','Cmpsc301');
INSERT INTO Teaches VALUES('5555','Econ101');
INSERT INTO Teaches VALUES('5555','Econ201');
INSERT INTO Teaches VALUES('6666','Econ202');
INSERT INTO Teaches VALUES('6666','Econ102');
INSERT INTO Teaches VALUES('6666','Econ301');
INSERT INTO Teaches VALUES('7777','Hist101');
INSERT INTO Teaches VALUES('7777','Hist102');
INSERT INTO Teaches VALUES('8888','Hist201');
INSERT INTO Teaches VALUES('8888','Hist202');
INSERT INTO Teaches VALUES('8888','Hist301');
INSERT INTO Teaches VALUES('9999','Desing101');
INSERT INTO Teaches VALUES('9999','Design201');
INSERT INTO Teaches VALUES('0000','Design202');
INSERT INTO Teaches VALUES('0000','Design203');
INSERT INTO Teaches VALUES('0000','Design301');

CREATE TABLE IF NOT EXISTS Taken (
    StudentID VARCHAR(200),
    ClassID VARCHAR(200),
    Status VARCHAR(200),
    Grade VARCHAR(200),
    FOREIGN KEY(StudentID) REFERENCES Students(StudentID) ON DELETE CASCADE,
    FOREIGN KEY(ClassID) REFERENCES Classes(ClassID) ON DELETE CASCADE,
    PRIMARY KEY(ClassID,StudentID)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS RequiredClasses (
    MajorID VARCHAR(200),
    ClassID VARCHAR(200),
    PRIMARY KEY(ClassID,MajorID),
    FOREIGN KEY(MajorID) REFERENCES Majors(MajorID) ON DELETE CASCADE,
    FOREIGN KEY(ClassID) REFERENCES Classes(ClassID) ON DELETE CASCADE
) ENGINE=InnoDB;

INSERT INTO RequiredClasses VALUES('MATH','Math101');
INSERT INTO RequiredClasses VALUES('MATH','Math202');
INSERT INTO RequiredClasses VALUES('MATH','Math301');
INSERT INTO RequiredClasses VALUES('CMPSC','Cmpsc101');
INSERT INTO RequiredClasses VALUES('CMPSC','Cmpsc203');
INSERT INTO RequiredClasses VALUES('CMPSC','Cmpsc301');
INSERT INTO RequiredClasses VALUES('CMPSC','Cmpsc202');
INSERT INTO RequiredClasses VALUES('ECON','Econ101');
INSERT INTO RequiredClasses VALUES('ECON','Econ102');
INSERT INTO RequiredClasses VALUES('ECON','Econ301');
INSERT INTO RequiredClasses VALUES('HIST','Hist101');
INSERT INTO RequiredClasses VALUES('HIST','Hist102');
INSERT INTO RequiredClasses VALUES('HIST','Hist301');
INSERT INTO RequiredClasses VALUES('DSGN','Desing101');
INSERT INTO RequiredClasses VALUES('DSGN','Design203');
INSERT INTO RequiredClasses VALUES('DSGN','Design301');

CREATE TABLE IF NOT EXISTS GenEds (
    GenEdID VARCHAR(200),
    GenEdName VARCHAR(200),
    RequiredCredits INTEGER,
    PRIMARY KEY(GenEdID)
) ENGINE=InnoDB;

INSERT INTO GenEds VALUES('HUM','Humanities',3);
INSERT INTO GenEds VALUES('TECH','Technical',3);
INSERT INTO GenEds VALUES('ART','Art',3);



CREATE TABLE IF NOT EXISTS Advisors (
    AdvisorID VARCHAR(200),
    MajorID VARCHAR(200),
    FOREIGN KEY(AdvisorID) REFERENCES Faculty(FacultyID) ON DELETE CASCADE,
    FOREIGN KEY(MajorID) REFERENCES Majors(MajorID) ON DELETE CASCADE,
    PRIMARY KEY(AdvisorID)
) ENGINE=InnoDB;

INSERT INTO Advisors VALUES('1111','MATH');
INSERT INTO Advisors VALUES('3333','CMPSC');
INSERT INTO Advisors VALUES('5555','ECON');
INSERT INTO Advisors VALUES('7777','HIST');
INSERT INTO Advisors VALUES('9999','DSGN');



CREATE TABLE IF NOT EXISTS GenEdClasses (
    GenEdID VARCHAR(200),
    ClassID VARCHAR(200),
    FOREIGN KEY(GenEdID) REFERENCES GenEds(GenEdID) ON DELETE CASCADE,
    FOREIGN KEY(ClassID) REFERENCES Classes(ClassID) ON DELETE CASCADE
) ENGINE=InnoDB;

INSERT INTO GenEdClasses VALUES('TECH','Math101');
INSERT INTO GenEdClasses VALUES('TECH','Math201');
INSERT INTO GenEdClasses VALUES('TECH','Math203');
INSERT INTO GenEdClasses VALUES('TECH','Cmpsc101');
INSERT INTO GenEdClasses VALUES('HUM','Econ101');
INSERT INTO GenEdClasses VALUES('HUM','Econ102');
INSERT INTO GenEdClasses VALUES('HUM','Hist101');
INSERT INTO GenEdClasses VALUES('HUM','Hist102');
INSERT INTO GenEdClasses VALUES('ART','Desing101');
INSERT INTO GenEdClasses VALUES('ART','Design202');

CREATE TABLE IF NOT EXISTS Taking (
    StudentID VARCHAR(200),
    ClassID VARCHAR(200),
    FOREIGN KEY(StudentID) REFERENCES Undergraduates(StudentID) ON DELETE CASCADE,
    FOREIGN KEY(ClassID) REFERENCES Classes(ClassID) ON DELETE CASCADE
) ENGINE=InnoDB;

INSERT INTO Taking VALUES('22222','Cmpsc101');
INSERT INTO Taking VALUES('00000','Cmpsc101');
INSERT INTO Taking VALUES('77777','Cmpsc101');

CREATE TABLE IF NOT EXISTS Undergraduates (
    StudentID VARCHAR(200),
    Year INTEGER,
    Major VARCHAR(200),
    GPA REAL,
    Advisor VARCHAR(200),
    PRIMARY KEY(StudentID),
    FOREIGN KEY(Major) REFERENCES Majors(MajorID),
    FOREIGN KEY(Advisor) REFERENCES Advisors(AdvisorID) ON DELETE CASCADE,
    FOREIGN KEY(StudentID) REFERENCES Students(StudentID) ON DELETE CASCADE
) ENGINE=InnoDB;

INSERT INTO Undergraduates VALUES('22222','Sophomore','MATH',3.819999999999999841,'1111');
INSERT INTO Undergraduates VALUES('33333','Senior','CMPSC',3.220000000000000195,'3333');
INSERT INTO Undergraduates VALUES('44444','Junior','CMPSC',2.689999999999999947,'3333');
INSERT INTO Undergraduates VALUES('55555','Senior','ECON',3.439999999999999947,'5555');
INSERT INTO Undergraduates VALUES('66666','Freshman','ECON',4.0,'5555');
INSERT INTO Undergraduates VALUES('77777','Senior','HIST',3.600000000000000088,'7777');
INSERT INTO Undergraduates VALUES('88888','Junior','HIST',2.819999999999999841,'7777');
INSERT INTO Undergraduates VALUES('99999','Senior','DSGN',3.919999999999999929,'9999');
INSERT INTO Undergraduates VALUES('00000','Sophomore','DSGN',2.319999999999999841,'9999');
INSERT INTO Undergraduates VALUES('12345','Freshman','Math',4.0,'1111');

CREATE TABLE IF NOT EXISTS Carts (
    StudentID VARCHAR(200),
    ClassID VARCHAR(200),
    FOREIGN KEY(StudentID) REFERENCES Undergraduates(StudentID) ON DELETE CASCADE,
    FOREIGN KEY(ClassID) REFERENCES Classes(ClassID) ON DELETE CASCADE,
    PRIMARY KEY(ClassID, StudentID)
) ENGINE=InnoDB;

INSERT INTO Carts VALUES('22222','Hist201');
