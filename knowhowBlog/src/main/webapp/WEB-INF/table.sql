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
	imagePath	VARCHAR(50)					 							/* 이미지 */
)

/* member 컬럼 생성 */
INSERT INTO MEMBERS (id, pwd, name, imagePath) VALUES('hyunhi7', 'gusgml12', 'kim', 'logo.png');

/* member 컬럼 탐색 */
SELECT * FROM MEMBERS;

/* PROJECT 테이블 생성 */
CREATE TABLE PROJ_BOARD (
	proj_num		INT		    	NOT NULL AUTO_INCREMENT 	PRIMARY KEY,
	proj_title		VARCHAR(50) 	NOT NULL DEFAULT "프로젝트",
	proj_writer		VARCHAR(50)		NOT NULL,
	proj_content	VARCHAR(500),
	proj_imagePath	VARCHAR(50),
	proj_date		DATETIME		DEFAULT CURRENT_TIMESTAMP,
	proj_disp_tf	BOOLEAN			NOT NULL  DEFAULT false
) ENGINE = InnoDB;

/* PROJECT 테이블 삭제 */
DROP TABLE PROJ_BOARD;

/* PROJECT 컬럼 생성 */
INSERT INTO PROJ_BOARD (proj_title,proj_writer,proj_content,proj_imagePath,proj_date,proj_disp_tf) 
				 VALUES('helloWorldPJ','hee', 'hello this is proj', 'logo.png', CURRENT_TIMESTAMP(),true);

INSERT INTO PROJ_BOARD (proj_writer,proj_content, proj_imagePath) VALUES('hyunhi7', 'hi', 'logo.png');

/* PROJECT 컬럼 탐색 */
select * from proj_board;


/* POST 테이블 생성 */
CREATE TABLE PROJ_POST_BOARD (
	post_num			INT				NOT NULL AUTO_INCREMENT 	PRIMARY KEY,
	post_title  		VARCHAR(50)		NOT NULL DEFAULT "포스팅",
	post_writer 		VARCHAR(50) 	NOT NULL,
	post_filePath		VARCHAR(50),
	post_content		VARCHAR(1500),
	post_date			DATETIME		DEFAULT CURRENT_TIMESTAMP,
	post_disp_tf		BOOLEAN			NOT NULL DEFAULT false,
	post_proj_num		INT,
	INDEX(post_proj_num),
	FOREIGN KEY(post_proj_num) REFERENCES PROJ_BOARD(proj_num) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE PROJ_POST_TAG (
	tag_num				INT				NOT NULL AUTO_INCREMENT 	PRIMARY KEY,
	tag_name			VARCHAR(50)		NOT NULL,
	tag_post_num		INT,
	INDEX(tag_num),
	FOREIGN KEY(tag_post_num) REFERENCES PROJ_POST_BOARD(post_num) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;


/* POST 테이블 삭제 */
DROP TABLE POST_BOARD;	

/* POST 컬럼 생성 */
INSERT INTO PROJ_POST_BOARD (post_title, post_writer, post_content, post_disp_tf, post_proj_num)
				VALUES ('hello', 'hyunhi7', 'hello this is code', false, 1);