# Utiliza una imagen base con Android SDK instalado
FROM openjdk:8-jdk

# Variables de entorno para Android SDK
ENV ANDROID_SDK_URL="https://dl.google.com/android/repository/sdk-tools-linux-4333796.zip" \
    ANDROID_BUILD_TOOLS_VERSION=30.0.2 \
    ANDROID_PLATFORM_VERSION="android-30" \
    ANDROID_HOME="/opt/android-sdk" \
    PATH=$PATH:/opt/android-sdk/platform-tools:/opt/android-sdk/tools/bin

# Actualiza e instala dependencias
RUN apt-get update && \
    apt-get install -y unzip && \
    apt-get clean

# Descarga e instala Android SDK
RUN mkdir -p $ANDROID_HOME && \
    wget -q $ANDROID_SDK_URL -O /tmp/sdk-tools.zip && \
    unzip -q /tmp/sdk-tools.zip -d $ANDROID_HOME && \
    rm -f /tmp/sdk-tools.zip

# Acepta las licencias de Android SDK
RUN yes | sdkmanager --licenses

# Instala versiones específicas de Android Build Tools y plataforma
RUN sdkmanager "build-tools;$ANDROID_BUILD_TOOLS_VERSION" "platforms;$ANDROID_PLATFORM_VERSION"

# Copia los archivos de la aplicación al contenedor
COPY . /app

# Establece el directorio de trabajo
WORKDIR /app

# Compila la aplicación
RUN ./gradlew assembleDebug

# Puedes modificar el comando para ejecutar tu aplicación en función de tus necesidades
CMD ["./gradlew", "installDebug"]
