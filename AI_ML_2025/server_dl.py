from flask import Flask, jsonify
from flask_cors import CORS, cross_origin
import joblib
import numpy as np
from flask import request
#import tensorflow as tf

import numpy as np
import cv2 as cv
import base64

# Khởi tạo FLASK server BACKEND 
app = Flask(__name__)
#Khởi tạo Flask CORS
CORS(app)
app.config['CORS_HEADERS'] = 'Content-Type'
app.config['MAX_CONTENT_LENGTH'] = 50 * 1024 * 1024 # 50 MB

def dem_so_mat(anh):
    #Hàm khởi tạo nhận diện
    face_cascade = cv.CascadeClassifier(cv.data.haarcascades + 'haarcascade_frontalface_default.xml')
    #Chuyển gray
    gray = cv.cvtColor(anh, cv.COLOR_BGR2GRAY)
    #Phát hiện khuôn mặt trong ảnh
    faces = face_cascade.detectMultiScale(gray, 1.2,10)
    so_mat=len(faces)
    return so_mat


def chuyen_base64_anh(anh_base64):
    try:
        anh_base64= np.fromstring(base64.b64decode(anh_base64), dtype=np.uint8)
        anh_base64= cv.imdecode(anh_base64, cv.IMREAD_ANYCOLOR)
    except:
        return None
    return anh_base64

@app.route('/nhandienkhuonmat', methods=['POST'])
@cross_origin(origion='*')
def nhandienkhuonmat_process():
    face_number=0
    # Đọc ảnh từ clients
    facebase64 = request.form.get("facebase64")

    #chuyển ảnh base64 về openCV format
    face = chuyen_base64_anh(facebase64)
    #Đếm số mặt trong ảnh

    face_number=dem_so_mat(face)
    return "Số mặt là = :"  + str(face_number)


if __name__ == '__main__':
    app.run(host='0.0.0.0',port='2001')