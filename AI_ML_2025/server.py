from flask import Flask, jsonify
from flask_cors import CORS, cross_origin
import joblib
import numpy as np
from flask import request


# Khởi tạo FLASK server BACKEND 
app = Flask(__name__)
#Khởi tạo Flask CORS
CORS(app)
app.config['CORS_HEADERS'] = 'Content-Type'


@app.route('/hello', methods=['GET','POST'])
@cross_origin(origion='*')
def api_hello():
    return jsonify({"message": "Hello from API!"})

@app.route('/add', methods=['GET','POST'])
@cross_origin(origion='*')
def add_process():
    a1  = int(request.args.get('sothunhat')) 
    a2  = int(request.args.get('sothuhai')) 
    kq=a1+a2
    return 'Kết quả là :' + str(kq)

@app.route('/remove', methods=['GET','POST'])
@cross_origin(origion='*')
def remove_process():
    a1  = int(request.args.get('a')) 
    a2  = int(request.args.get('b')) 
    kq=a1-a2
    return 'Kết quả là :' + str(kq)

@app.route('/viethoa', methods=['GET','POST'])
@cross_origin(origion='*')
def viethoa_process():
    s = request.args.get("param")
    return s.upper()

@app.route('/viethoaPOST', methods=['POST'])
@cross_origin(origion='*')
def viethoaPOST_process():
    s1 = request.form.get("param1")
    if s1:
        return s1.upper()
    else:
        return jsonify({"error": "Parameter 'param' not found in form data. Please send data as form-urlencoded with key 'param'."}), 400

if __name__ == '__main__':
    app.run(host='0.0.0.0',port='1999')