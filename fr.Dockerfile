FROM node:16.13-alpine as builder
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install 
COPY . .
RUN npm run build
COPY . .

FROM nginx:alpine 
RUN rm -rf /usr/share/nginx/html/*
COPY --from=builder /app/dist /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
