# Stage 1: Compile and build angular codebase

# Use official node iage as the base image
FROM node:latest as uild

# Set the working directory
WORKDIR /usr/local/app

# Add the source code to app
COPY ./ /usr/local/app/

# Install all the dependencies
RUN npm install

# Generate the build of the application
RUN npm run build


# Stage 2: Serve app with nginx image as the base image
FROM nginx:latest

# Copy the build output to replace the default nginx contents.
COPY --from=build /usr/local/app/dist/inventory-client/browser /usr/share/nginx/html

# Expose port 80
EXPOSE 80
