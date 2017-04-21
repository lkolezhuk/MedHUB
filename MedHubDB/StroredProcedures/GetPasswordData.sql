CREATE DEFINER=`root`@`localhost` PROCEDURE `GetPasswordData`(
	IN _UserEmail VARCHAR(256),
    OUT UserID_ INT,
    OUT PasswordHash_ VARCHAR(256),
    OUT PasswordSalt_ varchar(128)
)
BEGIN
	
    SELECT u.Id, l.PasswordHash, l.PasswordSalt
    INTO UserID_, PasswordHash_, PasswordSalt_
    FROM medhubdb.user u
		INNER JOIN medhubdb.userlogin l
			ON u.UserLogin_Id = l.Id
	WHERE u.Email = _UserEmail;
END