FROM node:18-alpine as build
WORKDIR /src
COPY . /src/front
RUN npm i pnpm@8.11.0
RUN pnpm install

EXPOSE 5173
