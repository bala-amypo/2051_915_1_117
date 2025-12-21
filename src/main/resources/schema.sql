CREATE DATABASE IF NOT EXISTS security_audit;
USE security_audit;

CREATE TABLE user_accounts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id VARCHAR(50) NOT NULL UNIQUE,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE login_events (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    ip_address VARCHAR(45) NOT NULL,
    location VARCHAR(100),
    device_id VARCHAR(100) NOT NULL,
    timestamp DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    login_status VARCHAR(20) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_accounts(id)
);

CREATE TABLE device_profiles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    device_id VARCHAR(100) NOT NULL,
    device_type VARCHAR(50),
    os_version VARCHAR(50),
    last_seen DATETIME,
    is_trusted BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (user_id) REFERENCES user_accounts(id)
);

CREATE TABLE policy_rules (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    rule_code VARCHAR(50) NOT NULL UNIQUE,
    description TEXT NOT NULL,
    severity VARCHAR(20) NOT NULL,
    conditions_json TEXT,
    active BOOLEAN DEFAULT TRUE
);

CREATE TABLE violation_records (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    policy_rule_id BIGINT NOT NULL,
    event_id BIGINT NOT NULL,
    violation_type VARCHAR(100),
    details TEXT,
    severity VARCHAR(20) NOT NULL,
    detected_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    resolved BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (user_id) REFERENCES user_accounts(id),
    FOREIGN KEY (policy_rule_id) REFERENCES policy_rules(id),
    FOREIGN KEY (event_id) REFERENCES login_events(id)
);
