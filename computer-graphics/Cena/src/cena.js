/*
* A estrutura básica do arquivo é:
* 1) Importar bibliotecas; 2) Criar a cena; 3) Criar e configurar a câmera;
* 4) Configurar renderizador e anexar câmera; 5) adicionar iluminação;
* 6) criar objetos e montar a cena; 7) renderizar a cena
*/
import * as THREE from "three";
import { OrbitControls } from "three/examples/jsm/controls/OrbitControls.js";
import { OBJLoader } from "three/examples/jsm/Addons.js";

// 1. criar uma cena básica
const cena = new THREE.Scene();
cena.backgroundColor = 0xffffff;
// habilita névoa na cena
cena.fog = new THREE.Fog(0xffffff, 0.0025, 50);

// 2. criar e configurar câmera
const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
camera.position.x = -3;
camera.position.y = 8;
camera.position.z = 2;

// 4. configurar renderizador e anexar câmera
const renderizador = new THREE.WebGLRenderer({ antialias: true });
// configura espaço de cores
renderizador.outputColorSpace = THREE.SRGBColorSpace;
// habilita sombras
renderizador.shadowMap.enabled = true;
renderizador.shadowMap.type = THREE.VSMShadowMap;
// define tamanho, cor e anexa no DOM
renderizador.setSize(window.innerWidth, window.innerHeight);
renderizador.setClearColor(0xffffff);
document.body.appendChild(renderizador.domElement);

// 5. adicionar iluminação
cena.add(new THREE.AmbientLight(0xdddddd));
const luzDirecional = new THREE.DirectionalLight(0xaaaaaa);
luzDirecional.position.set(5, 12, 8);
luzDirecional.castShadow = true;
luzDirecional.shadow.bias = -0.0005;
cena.add(luzDirecional);

// add orbitcontrols
const controlador = new OrbitControls(camera, renderizador.domElement);
controlador.maxPolarAngle = 90 * (Math.PI / 180);

// 6. criar objetos e montar a cena


// criar array de objetos
const objetos = [];
// função para adicionar cubos na cena

function criarCubo() {
  const geometria = new THREE.BoxGeometry();
  const material = new THREE.MeshPhongMaterial({ color: 0xFFFF00 });
  const cubo = new THREE.Mesh(geometria, material);

  cubo.position.set(
    Math.random() * 10 - 5,  // por que -5?    
    Math.random() * 10,      // por que não -5? 
    Math.random() * 10 - 5   // por que -5? 
  )

  cubo.castShadow = true;
  cena.add(cubo);
  objetos.push(cubo);
}

// programar o evento de clique no botão
const botao = document.getElementById("criarCubo");
botao.addEventListener("click", criarCubo)

function remover() {
  if (objetos.length > 0) {
    const obj = objetos.pop();
    cena.remove(obj);
  }
}

const botaoRemover = document.getElementById("remover");
botaoRemover.addEventListener("click", remover)

//carregar um obj
const objLoader = new OBJLoader();
objLoader.load('assets/cat/cat/cat.obj', (objeto)=>{
  objeto.scale.set(0.025, 0.025, 0.025);
  objeto.rotation.x = -Math.PI / 2;
  cena.add(objeto);
});



// criar um plano
const chaoGeometria = new THREE.PlaneGeometry(10, 10);
const chaoMaterial = new THREE.MeshLambertMaterial({ color: 0x00FF00 });
const chao = new THREE.Mesh(chaoGeometria, chaoMaterial);
chao.position.set(0, -2, 0);
chao.rotation.set(-Math.PI / 2, 0, 0);
chao.receiveShadow = true;
cena.add(chao);

// 7. renderizar a cena
function renderizar() {
  requestAnimationFrame(renderizar);
  for (const objeto of objetos) {
    objeto.rotation.x += Math.random() * 0.05;
    objeto.rotation.y += Math.random() * 0.05;
  }

  renderizador.render(cena, camera);
  controlador.update();
}
renderizar();
