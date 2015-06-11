-- This schema create script runs on every application load
-- Script failures will cause the application to fail to start
-- MySQL compatible schema
CREATE TABLE IF NOT EXISTS RISK_CONFIDENCE (
  ID BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  ALTERNATIVE_ID VARCHAR(100) NOT NULL,
  COURSE_ID VARCHAR(100) NOT NULL,
  MODEL_RISK_CONFIDENCE VARCHAR(100) NOT NULL,
  GROUP_ID CHAR(36)NOT NULL,
  DATE_CREATED DATETIME DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS CONFIGURATION (
  ID integer NOT NULL AUTO_INCREMENT,
  SSP_BASE_URL varchar(100) DEFAULT NULL,
  SSP_RISK_CONFIDENCE_THRESHOLD float DEFAULT NULL,
  SSP_ACTIVE boolean DEFAULT false,
  PRIMARY KEY (ID)
);