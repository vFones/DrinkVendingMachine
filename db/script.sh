#!/bin/sh

createuser -U postgres -d -E dbaprog3
createdb -U postgres prog3 -O dbaprog3
psql -U postgres -c "alter USER dbaprog3 WITH PASSWORD 'passwddba'"
psql -d prog3 -U dbaprog3 -W -f ddl.sql
psql -d prog3 -U dbaprog3 -W -f dml.sql
