FROM node:17.5.0-alpine
WORKDIR /MY-APP
ENV PATH="./node_modules/.bin:$PATH"
COPY . .
RUN npm run build
CMD ["npm", "start"]
