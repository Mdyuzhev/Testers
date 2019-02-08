CREATE TABLE IF NOT EXISTS testers (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(50)   NOT NULL,
  last_name  VARCHAR(100)  NOT NULL,
  testers_position VARCHAR(100)   NOT NULL,
  testers_skill  VARCHAR(100)  NOT NULL,
  experience DECIMAL  NOT NULL,
  location  VARCHAR(100)  NOT NULL
);