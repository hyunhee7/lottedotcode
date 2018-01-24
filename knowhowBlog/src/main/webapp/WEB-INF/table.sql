

CREATE TABLE MEMBERS (
	id 			VARCHAR(50) PRIMARY KEY, /* 아이디 */
	pwd			VARCHAR(50) NOT NULL, 	 /* 비밀번호 */
	name		VARCHAR(50) NOT NULL,	 /* 이름 */
	image		BLOB					 /* 이미지 */
)

CREATE TABLE PROJ_BOARD (
	proj_num	INT
	proj_name	VARCHAR(50) PRIMARY KEY,
	
)
