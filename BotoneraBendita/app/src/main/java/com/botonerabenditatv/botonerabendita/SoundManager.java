package com.botonerabenditatv.botonerabendita;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.SparseArray;
import android.util.SparseIntArray;

    public class SoundManager {
        private static SoundManager instance = null;
        private static final SparseArray<String> sounds = new SparseArray<String>() {
            {
                put(R.raw.aydioos, "Ayy diooosss");
                put(R.raw.bailarbajolalluvia, "Bailar bajo la lluvia");
                put(R.raw.callatelaboca, "Callate la boca");
                put(R.raw.comoo, "Comooo !?!?");
                put(R.raw.cortalabocha, "Corta la bocha");
                put(R.raw.entendeloquetedigopapa, "Entendes lo que te digo papá?");
                put(R.raw.esacanallayanki, "Esa canalla yanki");
                put(R.raw.fijate, "Fijate");
                put(R.raw.lasolasyelviento, "Las olas y el viento");
                put(R.raw.ledariamosundescanso, "Le dariamos un descanso");
                put(R.raw.meperdialgo, "Me perdi de algo ?");
                put(R.raw.noparanada, "No para nada");
                put(R.raw.putoputooo, "Putoo Putooo");
                put(R.raw.quedice, "Que dice");
                put(R.raw.queremas, "Quere mas?");
                put(R.raw.sacamela, "Sacamelá");
                put(R.raw.stopstopstop, "Stop Stop Stop");
                put(R.raw.teprometopenetrar, "Te prometo penetrar");
                put(R.raw.tuhermana, "Tu hermana!!!");
                put(R.raw.unquilombounquilombo, "Un quilombo!!!");
                put(R.raw.vamonuweel, "Vamoo Newellsss");
                put(R.raw.wowowoconmigo, "Wo Wo Wo Conmigo");
                put(R.raw.yadejamedejoder, "Ya dejame de joder!!!");
                put(R.raw.atucriterio, "Lo dejo a tu criterio");
                put(R.raw.bastaa, "Bastaaa!!!");
                put(R.raw.bohemia, "Bohemia'");
                put(R.raw.chorizo, "Chorizo");
                put(R.raw.tsunamiseminal, "Tsunami Seminal");
                put(R.raw.trescarajos, "Me importa tres carajos");
                put(R.raw.tengoaval, "Tengo aval");
                put(R.raw.tamoactivo, "Tamo activo");
                put(R.raw.sepuedesertanpelotudo, "No se puede ser tan pelotudo");
                put(R.raw.segundos, "Segundos");
                put(R.raw.rompiendoelcu, "Rompiendome el culo");
                put(R.raw.quetienequever, "Que tiene que ver");
                put(R.raw.quetepasoenlavida, "Que te paso en la vida");
                put(R.raw.quecosa, "Que cosa");
                put(R.raw.puedehabermas, "Y puede haber mas");
                put(R.raw.piripipi, "Piripipi");
                put(R.raw.pancasero, "Pan caserooo");
                put(R.raw.panadero, "Panaderoo");
                put(R.raw.nooooo, "Noooo!!!");
                put(R.raw.nohables, "No hables!!!");
                put(R.raw.necesidad, "Lo dice por necesidad");
                put(R.raw.motivados, "Estamos motivados");
                put(R.raw.mequieroiramicasa, "Me quiero ir a mi casa");
                put(R.raw.martillazo, "Le pego un martillazo");
                put(R.raw.maravilloso, "Maravilloso");
                put(R.raw.malaleche, "Mala leche");
                put(R.raw.lpantalones, "Agarrate los pantalones");
                put(R.raw.lerebendiga, "Que dios le re bendiga");
                put(R.raw.lavidaesasi, "La vida es asi");
                put(R.raw.lavamanos, "Se lava las manos");
                put(R.raw.lareputmadre, "La re puta madre que los pario");
                put(R.raw.ladrones, "Una manga de ladrones");
                put(R.raw.jajajaja, "Jajaja");
                put(R.raw.jajajaj2, "jajaja");
                put(R.raw.ieee, "Ieeee");
                put(R.raw.holasusana, "Hola susana");
                put(R.raw.hijodepualcahuete, "Hijo de puta alcahuete");
                put(R.raw.hermosohermoso, "Hermoso hermoso");
                put(R.raw.hastalohuevo, "Esta hasta los huevos");
                put(R.raw.fumon, "Para que fuma si le hace mal");
                put(R.raw.fiestalalalala, "Fiesta lalalala");
                put(R.raw.faltadecomprension, "Que falta de comprension");
                put(R.raw.esteotravez, "Este otra vez");
                put(R.raw.decilo, "Decilo");
                put(R.raw.daleponelo, "Dale ponelo");
                put(R.raw.daleboludo, "Dale boludo");
                put(R.raw.cruzardedos, "A cruzar los dedos");
                put(R.raw.crimenahi, "Crimen ahi");
                put(R.raw.creocreo, "Creo que se equivocó");
                put(R.raw.contestar, "Todavia no te puedo contestar");
                put(R.raw.concretamente, "Concretamente");
                put(R.raw.comotoda, "Me la voy a comer toda");
                put(R.raw.comiendochorizo, "Comiendo chorizo");
                put(R.raw.cokemone, "Cokemone");
                put(R.raw.circo, "Es un circo");
                put(R.raw.cierto, "Es cierto");
                put(R.raw.chupe, "Le gusta el chupe");
                put(R.raw.agarratelospantalones, "Nacho, Agarrate los pantalones");
                put(R.raw.aydios, "Ay dios");
                put(R.raw.chanchan, "Chan! Chan!");
                put(R.raw.churrochurro, "Churroo");
                put(R.raw.comotequedoeso, "Como te quedo eso eh");
                put(R.raw.cuidado, "Cuidado");
                put(R.raw.estanbuena, "Es tan buena");
                put(R.raw.muycool, "Muy cool");
                put(R.raw.nolohagasenor, "No lo haga señor!");
                put(R.raw.nosetienequeprender, "No se tiene que prender");
                put(R.raw.peliculayhamburgesas, "Pelicula y Hamburgesa");
                put(R.raw.porfavorbasta, "Por favor basta");
                put(R.raw.quecornopasa, "Que corno pasa");
                put(R.raw.salideahimaravilla, "Salí de ahi maravilla");
                put(R.raw.siganhablandoricardofort, "Sigan hablando de Ricardo");
                put(R.raw.sueniosson, "Los sueños...");
                put(R.raw.vivendelabasura, "Viven de la basura");
                put(R.raw.y, "Y ?");
                put(R.raw.ypuedehabermas, "Y puede haber mas");
                put(R.raw.aguantaa, "Aguanta!!!");
                put(R.raw.aguantebendita, "Aguante bendita!");
                put(R.raw.aycomomegustanestascosas, "Ay como me gustan estas cosas");
                put(R.raw.banio, "Baño");
                put(R.raw.betocasela, "Beetoo !!");
                put(R.raw.chicodecincoanios, "Chico de cinco años");
                put(R.raw.espero, "Espero");
                put(R.raw.hablandodefaso, "Esta hablando del faso!");
                put(R.raw.meapeno, "Me apenó");
                put(R.raw.mire, "Mire!");
                put(R.raw.muybuenagente, "Muy buena gente");
                put(R.raw.nomeponganmusica, "No me pongan musica");
                put(R.raw.patatodosustedes, "Pa todos ustedes!!");
                put(R.raw.sosterribleeh, "Sos terrible eh!");
                put(R.raw.telleganalalma, "Te llenan el alma");
                put(R.raw.tikitiki, "Tiki tiki");
                put(R.raw.tomasteaguasusana, "Que tomaste su?");
                put(R.raw.tomismalamasmejor, "Yo misma la mas mejor");
                put(R.raw.vamochiquito, "Vamo chiquito!!");
                put(R.raw.ahilotenesalpelotudo, "Ahí lo tenes el pelotudo");
                put(R.raw.andateatupalmera, "Andate a tu palmera");
                put(R.raw.aversiaprendes, "A ver si aprendes!!");
                put(R.raw.bestiahumana, "Bestia humana");
                put(R.raw.bolasllenas, "Perdon, pero me tienen las bolas llenas!!");
                put(R.raw.chau, "Chau!!");
                put(R.raw.cladoboludo, "Claro boludo!!");
                put(R.raw.cricricri, "Cri cri cri!!");
                put(R.raw.escuchenescuchen, "Escuchen escuchen!!");
                put(R.raw.esinsoportable, "Es insoportable!!");
                put(R.raw.esofuehace, "Eso fue hace 45 años!!");
                put(R.raw.holacomoestas, "Hola como estas");
                put(R.raw.lechemuchaleche, "Leche mucha leche!!");
                put(R.raw.paraparapara, "Pará pará pará");
                put(R.raw.paraunpocoloca, "Para un poco loca");
                put(R.raw.porfavoor, "Por favoor");
                put(R.raw.seguimos, "Seguimos");
                put(R.raw.selesuelstalacadena, "Se le suelta la cadena");
                put(R.raw.sepudriotodo, "Se pudrio todo");
                put(R.raw.sustopagani, "Susto Pagani");
                put(R.raw.tapadaporlagrasa, "Tapada por la grasa");
                put(R.raw.tengomiedo, "Tengo miedo");
                put(R.raw.tucumanopatasucia, "Tucumano para sucia!!");
                put(R.raw.unaamistad, "Una amistad");
                put(R.raw.ysenotamucho, "Y se nota mucho");

            }
        };
        private Context context;
        private SparseIntArray soundIDs;
        private SoundPool soundPool;

        private SoundManager() {
            this.context = null;
            this.soundPool = null;
            this.soundIDs = null;
            this.soundPool = new SoundPool(10, 3, 0);
            this.soundIDs = new SparseIntArray();
        }

        public static synchronized SoundManager getInstance() {
            SoundManager soundManager;
            synchronized (SoundManager.class) {
                if (instance == null) {
                    instance = new SoundManager();
                }
                soundManager = instance;
            }
            return soundManager;
        }

        public synchronized void init(Context c) {
            if (this.context == null) {
                this.context = c;
                for (int i = 0; i < sounds.size(); i++) {
                    int sound = sounds.keyAt(i);
                    this.soundIDs.put(sound, this.soundPool.load(this.context, sound, 1));
                }
            }
        }

        public int getSize() {
            return sounds.size();
        }

        public int keyAt(int position) {
            return sounds.keyAt(position);
        }

        public String getSoundName(int key) {
            return (String) sounds.get(key);
        }

        public boolean play(int soundResId) {
            AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
            float volume = ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
            Integer soundID = Integer.valueOf(this.soundIDs.get(soundResId));
            if (soundID == null) {
                return false;
            }
            this.soundPool.play(soundID.intValue(), volume, volume, 1, 0, 1.0f);
            return true;
        }
    }

