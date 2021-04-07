default: backend frontend

up:
	docker-compose -p gatech -f docker-compose.yml up -d

clean:
	docker-compose -p gatech -f docker-compose.yml down

.PHONY: backend
backend:
	docker build -t gatech/backend -f ./images/Dockerfile.backend ./backend

.PHONY: frontend
frontend:
	docker build -t gatech/frontend -f ./images/Dockerfile.frontend ./frontend
