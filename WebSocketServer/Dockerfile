# Use an official Node.js runtime as the base image
FROM node:14

# Set the working directory in the container
WORKDIR /app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install application dependencies
RUN npm install

# Copy the rest of the application code to the container
COPY . .

# Expose the port your application will run on
EXPOSE 5000

# Start the application
CMD export DATABASE=$DB_NAME && \
export DB_USERNAME=$DB_USER_NAME && npm start

