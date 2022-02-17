CREATE EVENT cleaning ON SCHEDULE EVERY 60 minute ENABLE -- чтобы успеть потестировать, но вообще наверное в задании предполагался не такой вариант очистки каптч
  DO
  DELETE FROM captcha_codes
  WHERE time < CURRENT_TIMESTAMP - INTERVAL 1 HOUR;