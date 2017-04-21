CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateUser`(
	IN _Name VARCHAR(45),
    IN _Surname VARCHAR(45),
    IN _Email VARCHAR(45),
    IN _PasswordHash VARCHAR(256),
    IN _PasswordSalt VARCHAR(45),
    IN _UserTitle VARCHAR(45),
    OUT UserID_ INT
)
BEGIN
	DECLARE loginID INT DEFAULT 0;
    DECLARE userProfileID INT DEFAULT 0;
    
	INSERT INTO medhubdb.userlogin(PasswordHash, PasswordSalt)
		VALUES (_PasswordHash, _PasswordSalt);
    
    SET loginID = LAST_INSERT_ID();
    
    SET FOREIGN_KEY_CHECKS = 0;
    
    INSERT INTO medhubdb.userprofile(RegistrationDate, Title)
    VALUES (NOW(), _UserTitle);
	
    SET userProfileID = LAST_INSERT_ID();
    
	INSERT INTO medhubdb.user(Name, Surname, Email, UserLogin_Id, UserProfile_Id)
	VALUES(_Name, _Surname, _Email, loginID, userProfileID);
    
    SET FOREIGN_KEY_CHECKS = 1;
    SET UserID_ = LAST_INSERT_ID();
END