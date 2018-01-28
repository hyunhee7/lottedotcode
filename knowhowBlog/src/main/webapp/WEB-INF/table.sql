show databases;
/* 테이블 확인 */
desc members;

/* 테이블 확인 */
DROP TABLE MEMBERS;

/* member 테이블 생성 */
CREATE TABLE MEMBERS (
	mem_num		INT		    NOT NULL AUTO_INCREMENT 	PRIMARY KEY,	/* num */
	id 			VARCHAR(50) NOT NULL, 									/* 아이디 */
	pwd			VARCHAR(50) NOT NULL, 	 								/* 비밀번호 */
	name		VARCHAR(50) NOT NULL,	 								/* 이름 */
	image		BLOB					 								/* 이미지 */
)

/* member 컬럼 생성 */
INSERT INTO MEMBERS (id, pwd, name, image) VALUES('hyunhi7', 'gusgml12', 'kim', 'resources/images/logo.png');

/* member 컬럼 탐색 */
SELECT * FROM MEMBERS;


CREATE TABLE PROJ_BOARD (
	proj_num	INT
	proj_name	VARCHAR(50) PRIMARY KEY,
)
