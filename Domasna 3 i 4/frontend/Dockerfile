FROM node:lts-alpine3.14

COPY . /frontend

WORKDIR /frontend

RUN yarn install
RUN yarn global add serve

EXPOSE 3000

CMD yarn build && serve -s build