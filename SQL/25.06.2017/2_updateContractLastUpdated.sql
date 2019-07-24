UPDATE `contract` con SET con.peiodic_last_updated_at = (SELECT MAX(cld.peiodic_last_updated_at) FROM contractLastDate cld WHERE cld.bankAccountNumber = con.bankAccountNumber)
WHERE con.bankAccountNumber IN (SELECT bankAccountNumber FROM contractLastDate) AND con.periodic_payment > 0;