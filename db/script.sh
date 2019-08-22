#!/bin/sh

createuser dbaprog3 -d -E
createdb prog3 -O dbaprog3
psql -c "alter USER dbaprog3 WITH PASSWORD 'passwddba'"
psql -d prog3 -U dbaprog3 -W -f ddl.sql
psql -d prog3 -U dbaprog3 -W -f dml.sql
