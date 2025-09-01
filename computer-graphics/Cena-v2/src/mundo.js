/*
* A estrutura básica do arquivo é:
* 1) Importar bibliotecas; 2) Criar a cena; 3) Criar e configurar a câmera;
* 4) Configurar renderizador e anexar câmera; 5) adicionar iluminação;
* 6) criar objetos e montar a cena; 7) renderizar a cena
*/
import * as THREE from "three";
import { OrbitControls } from "three/examples/jsm/controls/OrbitControls.js";
import { EXRLoader } from "three/examples/jsm/Addons.js";
import { texture } from "three/src/nodes/TSL.js";

// 1. criar uma cena básica
const cena = new THREE.Scene();
cena.backgroundColor = 0xffffff;
// habilita névoa na cena
//cena.fog = new THREE.Fog(0xffffff, 0.0025, 50);

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
cena.add(new THREE.AmbientLight(0xaaaaaa));
const luzDirecional = new THREE.DirectionalLight(0xffffff);
luzDirecional.position.set(5, 12, 8);
luzDirecional.castShadow = true;
luzDirecional.shadow.bias = -0.0005;
cena.add(luzDirecional);

// add orbitcontrols
const controlador = new OrbitControls(camera, renderizador.domElement);
controlador.maxPolarAngle = 90 * (Math.PI / 180);

const exrLoader = new EXRLoader();
exrLoader.load('assets/outdoor/outdoor_chapel_4k.exr', (texture) => {
  texture.mapping = THREE.EquirectangularReflectionMapping;
  createSkybox(texture);
});

function createSkybox(textura) {
    const esferaGeometria = new THREE.SphereGeometry(500, 60, 40);
    const esferaMaterial = new THREE.MeshBasicMaterial({
        map: textura,
        side: THREE.BackSide
    });

    const skybox = new THREE.Mesh(esferaGeometria, esferaMaterial);
    cena.add(skybox);
}

// 7. renderizar a cena
// percorrer o array de objetos para rotacioná-los
function renderizar() {
  requestAnimationFrame(renderizar);
  renderizador.render(cena, camera);
  controlador.update();
}
renderizar();
